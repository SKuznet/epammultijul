package hw7.Conditional;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CatFeeder {
    public static void main(String[] args) {
        Feeder feeder =  new Feeder();
        Owner richOwner =  new Owner(feeder, PersonState.A_LOT_OF_MONEY);
        Owner normalOwner =  new Owner(feeder, PersonState.ENOUGHT_MONEY);
        Owner poorOwner =  new Owner(feeder, PersonState.NO_MONEY);
        new Thread(richOwner).start();
        new Thread(normalOwner).start();
        new Thread(poorOwner).start();
    }
}

class Feeder {
    private ReentrantLock lock;
    private Condition condition;
    private CatState catState;

    public Feeder() {
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
        this.catState = CatState.HUNGRY;
    }

    public void feed() {
        lock.lock();
        try {
            while (catState != CatState.HUNGRY){
                condition.await();
            }
            catState = CatState.FULL;
            System.out.println("Cat is Full");
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void setOnDiet() {
        lock.lock();
        try {
            while (catState != CatState.OVERFEED){
                condition.await();
            }
            catState = CatState.HUNGRY;
            System.out.println("Cat is hungry");
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void feedMore() {
        lock.lock();
        try {
            while (catState != CatState.FULL){
                condition.await();
            }
            catState = CatState.OVERFEED;
            System.out.println("Cat is overfeed");
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class Owner implements Runnable {
    private PersonState personState;
    private Feeder feeder;

    public Owner(Feeder feeder, PersonState personState) {
        this.feeder = feeder;
        this.personState = personState;
    }

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            if (personState == PersonState.A_LOT_OF_MONEY) {
                feeder.feedMore();
            } else if (personState == PersonState.ENOUGHT_MONEY) {
                feeder.feed();
            } else {
                feeder.setOnDiet();
            }
        }
    }
}


