package com.epam.multi.homework2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ThreadClass t1 = new ThreadClass(Thread.MAX_PRIORITY);
        ThreadClass t2 = new ThreadClass(Thread.MIN_PRIORITY);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(t1);
        executorService.submit(t2);

        executorService.shutdown();
        
        executorService = Executors.newCachedThreadPool();
        List<Future<String>> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(executorService.submit(new CallClass(i)));
        }
        try {
            for (Future<String> fut : list) {
                System.out.println(fut.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            LOG.error(e.getMessage(), e);
        } finally {
            executorService.shutdown();
        }
    }
}
