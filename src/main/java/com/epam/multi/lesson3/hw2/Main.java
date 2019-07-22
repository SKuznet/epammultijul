package com.epam.multi.lesson3.hw2;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.executeFirstTask();
        main.waitForNextTask();
        main.executeSecondTask();
    }

    private ExecutorService executorService = Executors.newCachedThreadPool();
    private ArrayList<Future<String>> results = new ArrayList<>();

    private void executeFirstTask(){
        for (int i = 0; i < 5; i++) {
            executorService.execute(new TestRunnable(i+1));
        }
    }

    private void waitForNextTask(){
        try {
            Thread.sleep(500);
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void executeSecondTask(){
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
}
