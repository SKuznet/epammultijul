package com.epam.multi.homeworks.homework6;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchEx {
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

class ExampleThread implements Runnable {
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
