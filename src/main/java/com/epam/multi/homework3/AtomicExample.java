package com.epam.multi.homework3;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class shows  logic of atomic classes, updating i number in thread safe mode
 */
public class AtomicExample implements Runnable {
    private AtomicInteger i = new AtomicInteger(1);

    /**
     * Repeats multiply operation endlessly
     */
    @Override
    public void run() {
        while (true) {
            multiply();
        }
    }

    private int getValue() {
        return i.get();
    }

    private void multiply() {
        i.updateAndGet(a -> a * 10);
    }

    /**
     * Runs two threads - first one is aborting program after 5 sec, second - prints atomic number
     * if it is bigger than 1.000.000
     */
    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.err.println("Aborted!");
                System.exit(0);
            }
        }, 5000);

        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicExample atomicExample = new AtomicExample();
        executorService.submit(atomicExample);

        while (true) {
            int val = atomicExample.getValue();
            if (val > 1000000) {
                System.err.println(val);
                System.exit(0);
            }
        }
    }
}
