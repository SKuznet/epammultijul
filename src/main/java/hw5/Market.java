package main.java.hw5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Market {
    ReentrantLock lock;
    Condition condition;
    int product;

    public Market () {
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }
    public void get() {
        lock.lock();

        try {
            while (product < 1) {
                condition.await();
            }

            product--;

            System.out.println("Buyer buy 1 product");
            System.out.println("Products on storage: " + product);

            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void put() {
        lock.lock();

        try {
            while (product >= 3) {
                condition.await();
            }

            product++;

            System.out.println("Manufacturer added 1 new product");
            System.out.println("Products on storage: " + product);

            // signal to all
            condition.signalAll();


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
