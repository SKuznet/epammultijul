package com.epam.multi.lesson6.homework5;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreWorker implements Runnable {
    private Semaphore semaphore;
    private int digCount;
    private int workerId;

    public SemaphoreWorker(Semaphore semaphore, int philosopherId) {
        this.semaphore = semaphore;
        this.workerId = philosopherId;
    }

    public void run() {
        try {
            while (digCount < 4) {
                semaphore.acquire();
                System.out.println("SemaphoreWorker " + workerId + " started to dig a hole...");
                TimeUnit.MILLISECONDS.sleep(500);
                digCount++;
                System.out.println("SemaphoreWorker " + workerId + " digging " + digCount);
                System.out.println("SemaphoreWorker " + workerId + " stopped digging the hole...");
                semaphore.release();
                TimeUnit.MILLISECONDS.sleep(500);
            }
        } catch (InterruptedException e) {
            System.err.println("SemaphoreWorker " + workerId + " died of heart attack...");
        }
    }
}
