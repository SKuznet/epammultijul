package com.epam.multi.homeworks.homework5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockClass implements Runnable{
    int name;
    private boolean isInterrupt;
    Lock lock;

    public LockClass(int name, boolean isInterrupt, ReentrantLock lock) {
        this.name = name;
        this.isInterrupt = isInterrupt;
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + "Trying to lock...");

        try {
            if (isInterrupt) {
                lock.lockInterruptibly();
            } else {
                lock.lock();
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + ": " + "Acquiring lock failed due to " + e);
            return;
        }

        System.out.println(Thread.currentThread().getName() + ": " + "Got lock(" + name + ")");


        try {
            if (name == 1) {
                TimeUnit.SECONDS.sleep(3);
            } else {
                TimeUnit.MILLISECONDS.sleep(2500);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + ": " + "Sleep interrupted");
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + ": " + "Unlocked(" + name + ")");
        }
    }
}
