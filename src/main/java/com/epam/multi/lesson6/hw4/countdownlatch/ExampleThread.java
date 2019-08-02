package com.epam.multi.lesson6.hw4.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class ExampleThread implements Runnable {

    private CountDownLatch latch;

    public ExampleThread(CountDownLatch latch) {
        this.latch = latch;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            latch.countDown();
        }
    }
}


