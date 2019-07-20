package com.epam.multi.lesson3.homework.task2;

import java.util.ArrayList;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            results.add(executorService.submit(new MurzikCallable(i)));
        }

        for (Future<String> futureString : results) {
            try{
                System.out.println(futureString.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } finally {
                executorService.shutdown();
            }
        }
    }
}
