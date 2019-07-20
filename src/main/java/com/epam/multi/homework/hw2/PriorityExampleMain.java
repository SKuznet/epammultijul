package com.epam.multi.homework.hw2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PriorityExampleMain {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        Thread thread1 = new Thread(new PriorityExample(1));
        Thread thread2 = new Thread(new PriorityExample(9));

        executorService.submit(thread1);
        executorService.submit(thread2);

        executorService.shutdown();
    }
}