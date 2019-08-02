package com.epam.multi.lesson8;

public class LiveLockExample {

    public static void main(String[] args) {
        final Dinner husband = new Dinner("Bob");
        final Dinner wife = new Dinner("Alice");

        final Spoon spoon = new Spoon(husband);

        new Thread(new Runnable() {
            @Override
            public void run() {
                husband.eatWith(spoon,wife);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                wife.eatWith(spoon,husband);
            }
        }).start();
    }


    static class Spoon{
        private Dinner owner;

        public Dinner getOwner() {
            return owner;
        }

        public void setOwner(Dinner owner) {
            this.owner = owner;
        }

        public Spoon(Dinner owner) {
            this.owner = owner;
        }

        synchronized void use(){
            System.out.printf("%s has eaten", owner.getName());
        }
    }

    static class Dinner{
        private String name;
        private boolean isHungry;

        public Dinner(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public boolean isHungry() {
            return isHungry;
        }

        public Dinner(String name, boolean isHungry) {
            this.name = name;
            this.isHungry = true;
        }

        public void eatWith(Spoon spoon, Dinner spouse){
            while (isHungry){
                if (spoon.owner != this){
                    try{
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        continue;
                    }
                    continue;
                }
                if (spouse.isHungry){
                    System.out.printf("%s: You eat first, my darling %s!%n",name, spouse.getName());
                    spoon.setOwner(spouse);
                    continue;
                }

                spoon.use();
                isHungry = false;
                System.out.printf("%s I am full, my darling %s!%n",name, spouse.getName());
                spoon.setOwner(spouse);
            }
        }
    }
}
