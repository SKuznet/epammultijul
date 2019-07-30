package com.epam.multi.homeworks.homework2;



import java.util.ArrayList;
import java.util.concurrent.*;

public class CallableEx {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            results.add(executorService.submit(new CallableImpl(i)));
        }

        for (Future<String> fs : results) {
            try {
                System.out.println(fs.get(100, TimeUnit.MILLISECONDS));
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                e.printStackTrace();
            } finally {
                executorService.shutdown();
            }
        }
    }
}
