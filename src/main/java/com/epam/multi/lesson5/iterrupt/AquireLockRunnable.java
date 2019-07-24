package com.epam.multi.lesson5.iterrupt;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AquireLockRunnable implements Runnable {
    private int id;
    private boolean isInterrupt;
    private ReentrantLock lock;

    public AquireLockRunnable(int id, ReentrantLock lock) {
        this.id = id;
        this.lock = lock;
        this.isInterrupt = true;
    }

    public AquireLockRunnable(int id, boolean isInterrupt, ReentrantLock lock) {
        this.id = id;
        this.isInterrupt = isInterrupt;
        this.lock = lock;
    }

    private static void print(String text) {
        System.err.println(Thread.currentThread().getName() + ": " + text);
    }

    @Override
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
