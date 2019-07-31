package com.epam.multi.lesson3.hw2;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FiveSecTimers implements Runnable {
    public int seconds = 5;
    private volatile double d;
    private int priority;

    public FiveSecTimers(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return Thread.currentThread() + " seconds left: " + seconds;
    }

    public void startTimer() {
        while (--seconds != 0) {
            for (int i = 0; i < 100000; i++) {
                d += (Math.PI + Math.E) / (double) i;

                if (i % 1000 == 0) {
                    Thread.yield();
                }
            }
            System.out.println(this);
        }
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        startTimer();
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new FiveSecTimers(Thread.MAX_PRIORITY));

        for (int i = 0; i < 5; i++) {
            executorService.execute(new FiveSecTimers(Thread.MIN_PRIORITY));

        }
        executorService.shutdown();
    }
}
