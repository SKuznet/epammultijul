package com.epam.multi.lesson5.homework4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class InterruptLockRunnable implements  Runnable {

    private int id;
    private boolean isInterrupt;
    private ReentrantLock lock;


    public InterruptLockRunnable(int id, boolean isInterrupt, ReentrantLock lock) {
        this.id = id;
        this.isInterrupt = isInterrupt;
        this.lock = lock;
    }

    private static void print(String text) {
        System.err.println(Thread.currentThread().getName() + ": " + text);
    }

    public void run() {
        print("Trying to lock...");
        try {
            if (isInterrupt) {
                lock.lockInterruptibly();
            } else {
                lock.lock();
            }
        } catch (InterruptedException e) {
            print("Acquiring lock failed due to " + e);
            return;
        }
        print("Got lock(" + id + ")");
        try {
            if (id == 1) {
                TimeUnit.SECONDS.sleep(3);
            } else {
                TimeUnit.MILLISECONDS.sleep(2500);
            }
        } catch (InterruptedException e) {
            print("Sleep interrupted");
        } finally {
            lock.unlock();
            print("Unlocked(" + id + ")");
        }
    }
}
