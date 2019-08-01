package com.epam.multi.lesson4.hw3;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerHW implements Runnable {
    private AtomicInteger countdownByTwo = new AtomicInteger(21);

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.err.println("Aborting...");
                System.exit(0);
            }
        }, 10000);

        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicIntegerHW atomicIntegerHW = new AtomicIntegerHW();
        executorService.execute(atomicIntegerHW);
        executorService.shutdown();

        while (true) {
            int val = atomicIntegerHW.getValue();

            if (val % 2 == 0) {
                System.err.println(val);
                System.exit(0);
            }
        }
    }

    public int getValue() {
        return countdownByTwo.get();
    }

    private void decrement() {
        countdownByTwo.addAndGet(-2);
    }

    @Override
    public void run() {
        while (true) {
            decrement();
        }
    }
}
