package com.epam.multi.hw4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static AtomicInteger i = new AtomicInteger(0);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new AtomicDecrement(1));
        executorService.execute(new AtomicDecrement(2));
    }

}
