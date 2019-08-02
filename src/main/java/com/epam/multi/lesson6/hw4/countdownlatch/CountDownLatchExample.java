package com.epam.multi.lesson6.hw4.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        System.out.println("Starting of thread");

        new ExampleThread(countDownLatch);

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Finished...");
    }
}
