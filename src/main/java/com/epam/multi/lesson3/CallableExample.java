package com.epam.multi.lesson3;

import java.util.ArrayList;
import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            results.add(executorService.submit(new TaskWithResult(i)));
        }

        for (Future<String> fs : results) {
            try{
                System.out.println(fs.get(1, TimeUnit.MILLISECONDS));
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                e.printStackTrace();
            } finally {
                executorService.shutdown();
            }
        }
    }
}
