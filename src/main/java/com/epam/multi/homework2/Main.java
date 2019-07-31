package com.epam.multi.homework2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Class release using of priority and Callable classes in thread
 */
public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    /**
     * Method runs two threads with different priorities first (in fixed thread pool),
     * and after that uses callable class to return info about different threads
     * */
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new PriorityClass(Thread.MAX_PRIORITY));
        executorService.submit(new PriorityClass(Thread.MIN_PRIORITY));
        executorService.shutdown();

        executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> list = new ArrayList<>();
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
