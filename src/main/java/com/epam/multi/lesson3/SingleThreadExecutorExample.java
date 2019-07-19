package com.epam.multi.lesson3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorExample {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new CastSpell());
        }

        executorService.shutdown();
    }
}
