package myexperiments.lesson3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        ExecutorService executorService = Executors.newCachedThreadPool();

        List<Future<String>> results = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            results.add(executorService.submit(new TaskWithResult(i)));
        }

        for (Future<String> result : results) {
            try {
                System.out.println(result.get(1, TimeUnit.MILLISECONDS));
            } catch (InterruptedException
                    | ExecutionException
                    | TimeoutException e) {
                e.printStackTrace();
            } finally {
                executorService.shutdown();
            }
        }
    }

}
