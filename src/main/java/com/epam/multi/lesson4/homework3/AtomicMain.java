package com.epam.multi.lesson4.homework3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicMain implements Runnable {
    private AtomicLong i = new AtomicLong(5);

    public static void main(String[] args) {


        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicMain atomicMain = new AtomicMain();
        executorService.execute(atomicMain);

        while (true) {
            Long val = atomicMain.getValue();

            if (val % 432532 == 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }

    public Long getValue() {
        return i.get();
    }

    private void increment() {
        i.incrementAndGet();
    }

    public void run() {
        while (true) {
            increment();
        }
    }
}
