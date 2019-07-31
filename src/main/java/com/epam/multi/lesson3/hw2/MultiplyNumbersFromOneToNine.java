package com.epam.multi.lesson3.hw2;

import java.util.ArrayList;
import java.util.concurrent.*;

public class MultiplyNumbersFromOneToNine {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            results.add(executorService.submit(new Multiplier(i)));
        }

        for (Future<String> fs : results) {

            try {
                System.out.println(fs.get(10, TimeUnit.MILLISECONDS));
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                e.printStackTrace();
            } finally {
                executorService.shutdown();
            }

        }
    }
}
