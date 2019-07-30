package com.epam.multi.homeworks.homework4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample implements Runnable {

    private AtomicInteger count = new AtomicInteger();

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            count.incrementAndGet();
        }
    }

    public int getCount() {
        return this.count.get();
    }


    public static void main(final String[] args) {
        AtomicIntegerExample aie = new AtomicIntegerExample();


        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 2; i++) {
            executorService.execute(aie);
        }

        executorService.shutdown();
        System.out.println("Processing count=" + aie.getCount());


    }


}
