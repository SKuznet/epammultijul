package com.epam.multi.lesson3.hw2;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            executorService.execute(new TestRunnable(i+1));
        }

        waitForNextTask();

        for (int i = 0; i < 10; i++) {
            results.add(executorService.submit(new TestCollable()));
        }

        for (Future<String> fs: results) {
            try {
                System.out.println(fs.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } finally {
                executorService.shutdown();
            }
        }
    }

    static private void waitForNextTask(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
