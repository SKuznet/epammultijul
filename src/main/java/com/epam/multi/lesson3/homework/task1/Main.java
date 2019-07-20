package com.epam.multi.lesson3.homework.task1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new MurzikRunnable(Thread.MAX_PRIORITY));

        for (int i = 0; i < 5; i++) {
            executorService.execute(new MurzikRunnable(Thread.MIN_PRIORITY));
        }

        executorService.shutdown();
    }
}
