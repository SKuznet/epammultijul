package light.hw2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorServiceForCallable = Executors.newFixedThreadPool(10);
        ExecutorService executorServiceForRunnable = Executors.newFixedThreadPool(10);

        for (int i = 1; i < 11; i++) {
            executorServiceForRunnable.submit(new RunnableImpl(i));
        }
        Thread.sleep(500);
        for (int i = 1; i < 5; i++) {
            Future<Integer> future = executorServiceForCallable.submit(new CallableImpl());
            System.out.println(future.get());
        }

        executorServiceForCallable.shutdown();
        executorServiceForRunnable.shutdown();
    }
}
