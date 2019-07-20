package com.epam.multi.lesson1.hw2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MainCallable implements Callable {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future> list = new ArrayList<>();
        Callable<String> callable = new MainCallable();

        for (int i = 0; i < 10; i++) {
            Future<String> future = executorService.submit(callable);
            list.add(future);
        }
        for (Future<String> future: list) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
    }

    @Override
    public Object call() throws Exception {
        Thread.sleep(1000);
        return Thread.currentThread().getName();
    }
}
