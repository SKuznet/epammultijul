package com.epam.multi.homeworks.homework2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimplePriorities implements Runnable{
    private int countDown = 5;
    private volatile double d;
    private int priority;

    @Override
    public String toString() {
        return Thread.currentThread() + ":" + countDown;
    }

    private SimplePriorities(int priority) {
        this.priority = priority;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);

        while (true) {
            // high load operation
            for (int i = 0; i < 5; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Thread.yield();
            }

            System.out.println(this);

            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new SimplePriorities(Thread.MAX_PRIORITY));

        for (int i = 0; i < 5; i++) {
            executorService.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }

        executorService.shutdown();
    }
}
