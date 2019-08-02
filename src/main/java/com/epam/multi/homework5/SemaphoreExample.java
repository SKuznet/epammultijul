package com.epam.multi.homework5;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Class creates 4 threads with semaphore
 */
public class SemaphoreExample {

    /**
     * Runs 4 threads
     */
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new MyThread(semaphore));
        executorService.submit(new MyThread(semaphore));
        executorService.submit(new MyThread(semaphore));
        executorService.submit(new MyThread(semaphore));

        executorService.shutdown();
    }
}

/**
 * Class implements semaphore logic - fixed amount of threads that can run simultaneously
 */
class MyThread extends Thread {
    private static final Logger LOG = LoggerFactory.getLogger(MyThread.class);

    private Semaphore semaphore;

    MyThread(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    /**
     * Takes semaphore (if available) for a while and releases it
     */
    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.err.println("Hello " + this.getName());
            sleep(2000);
        } catch (InterruptedException e) {
            LOG.error(e.getMessage(), e);
        } finally {
            semaphore.release();
            System.err.println("Goodbye " + this.getName());
        }
    }
}
