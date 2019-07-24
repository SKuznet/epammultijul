package com.epam.multi.lesson3.homework2;

import java.util.ArrayList;
import java.util.concurrent.*;


public class MainFuture {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList();
        for (int i = 0; i < 7; i++) {
            results.add(executorService.submit(new ThreadWithSomeResult("it's a thread number " +i)));
        }

        for (Future<String> fs : results) {
            try {
                System.out.println(fs.get(100, TimeUnit.MILLISECONDS));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                executorService.shutdown();
            }
        }

    }
}

