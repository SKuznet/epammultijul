package com.epam.multi.homework4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class working with locks
 */
public class LockExample extends Thread {
    private static final Logger LOG = LoggerFactory.getLogger(LockExample.class);

    /**
     * Working with locks and lockInterruptibly() method
     */
    @Override
    public void run() {
        ReentrantLock r = new ReentrantLock();
        r.lock();
        System.err.println("First lock(): lock count: " + r.getHoldCount());

        r.tryLock();
        System.err.println("First tryLock() on thread lock count: " + r.getHoldCount());

        try {
            r.lockInterruptibly();
            System.err.println("Check lockInterruptibility(). Lock count: " + r.getHoldCount());
        } catch (InterruptedException e) {
            LOG.error(e.getMessage(), e);
        } finally {
            r.unlock();
            System.err.println("Unlocked, lock count: " + r.getHoldCount());
        }

        r.unlock();
        System.err.println("Unlocked, lock count: " + r.getHoldCount());

        r.unlock();
        System.err.println("Unlocked, lock count: " + r.getHoldCount());
    }

    /**
     * Creates one thread and executes it
     */
    public static void main(String[] args) {
        LockExample ex = new LockExample();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(ex);

        executorService.shutdown();
    }
}
