package hw4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ATM {
    
    public static final ATM atm = new ATM();
    private static AtomicInteger money;
    private Lock lock;
    private boolean isLocked;


    private ATM() {
        this.money = new AtomicInteger(0);
        this.lock = new ReentrantLock();
        this.isLocked = false;

    }

    public void getMoney(int amount) {
        try{
            isLocked = lock.tryLock(10, TimeUnit.MILLISECONDS);
            if (isLocked){
                int intMoney=money.get();
                if (intMoney>=amount) {
                    System.err.println("New amount: " + money.addAndGet(-amount));
                } else {
                    System.err.println("Not enough money");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (isLocked)
                lock.unlock();
            isLocked = false;
        }
        
    }

    public void addMoney(int amount) {
        System.err.println("New amount: " + money.addAndGet(amount));
    }

    public void seeMoney() {
        System.err.println("New amount: " + money.get());
    }
}
