package com.epam.multi.homework5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Class creates 3 threads with common latch
 */
public class CountDownLatchExample {
    private static final Logger LOG = LoggerFactory.getLogger(CountDownLatchExample.class);

    /**
     * Runs 3 threads with common latch and waiting for their finish
     */
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(3);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new CountThread("T1", latch));
        executorService.submit(new CountThread("T2", latch));
        executorService.submit(new CountThread("T3", latch));

        try {
            latch.await();
        } catch (InterruptedException e) {
            LOG.error(e.getMessage(), e);
        }

        System.err.println("All threads are ready");
        executorService.shutdown();
    }
}

/**
 * Class implements latch logic
 * */
class CountThread extends Thread {
    private static final Logger LOG = LoggerFactory.getLogger(CountThread.class);

    private final String name;
    private final CountDownLatch latch;

    CountThread(String name, CountDownLatch latch) {
        this.name = name;
        this.latch = latch;
    }

    /**
     *  Sleeps for 1 sec and decrements the count of the latch
     * */
    @Override
    public void run() {
        System.err.println(name + " starting");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            LOG.error(e.getMessage(), e);
        }
        System.err.println(name + " ready");
        latch.countDown();
    }
}
