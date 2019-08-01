package com.epam.multi.lesson6.homework5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTourist implements Runnable {
    private CountDownLatch latch;

    public CountDownLatchTourist(CountDownLatch latch) {
        this.latch = latch;
        new Thread(this).start();
    }

    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(100 + (int)(Math.random() * ((500 - 100) + 1)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Tourist from " + Thread.currentThread().getName() + " is ready!");
        latch.countDown();
    }
}
