package com.epam.multi.lesson8;

public class LiveLockExample {

    public static void main(String[] args) {
        final  Diner husband = new Diner("Siri");
        final Diner wife = new Diner("Alice");

        final Spoon sp = new Spoon(husband);

        new Thread(new Runnable() {
            @Override
            public void run() {
                husband.eatWith(sp, wife);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                wife.eatWith(sp, husband);
            }
        }).start();
    }

    static class Spoon {
        private Diner owner;

        public Spoon(Diner owner) {
            this.owner = owner;
        }

        public Diner getOwner() {
            return owner;
        }

        synchronized void setOwner(Diner diner) {
            owner = diner;
        }

        synchronized void use() {
            System.out.printf("%s has eaten", owner.name);
        }

    }

    static class Diner {
        private String name;
        private boolean isHungry;

        public Diner(String name) {
            this.name = name;
            isHungry = true;
        }

        public String getName() {
            return name;
        }

        public boolean isHungry() {
            return isHungry;
        }

        public void eatWith(Spoon spoon, Diner spouse) {
            while (isHungry) {
                if(spoon.owner != this) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        continue;
                    }
                    continue;
                }

                if (spouse.isHungry) {
                    System.out.printf("%s: You eat first my darling  %s!%n", name, spouse.getName());
                    spoon.setOwner(spouse);
                    continue;
                }

                spoon.use();
                isHungry = false;
                System.out.printf("%s: I am stuffed, my darling %s!%n", name, spouse.getName());
                spoon.setOwner(spouse);
            }
        }
    }
}
