package com.epam.multi.lesson7.conditional;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Home {
    private ReentrantLock lock;
    private Condition condition;
    private int feed;

    public Home() {
        lock = new ReentrantLock();
        condition = lock.newCondition();
        feed = 1;
    }

    public void get() {
        lock.lock();
        try {
            while (feed < 1){
                condition.await();
            }

            feed--;

            System.out.println("Feed has got by cat");
            System.out.println("Current feed is " + feed);

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
            while (feed >= 5){
                condition.await();
            }

            feed++;

            System.out.println("Feed has given to cat");
            System.out.println("Current feed is " + feed);

            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
