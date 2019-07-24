package com.epam.multi.lesson3.homework2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainPriorities {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            executorService.execute(new SimpleThreadClass(Thread.MIN_PRIORITY));
        }

        for (int i = 0; i < 3; i++) {
            executorService.execute(new SimpleThreadClass(Thread.MAX_PRIORITY));
        }
        executorService.shutdown();

        }
    }

