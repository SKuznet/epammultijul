package hw2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = Thread.MIN_PRIORITY; i < Thread.MAX_PRIORITY; i++) {
            executorService.submit(new RunnableEx(i));
            try {
                System.out.println(executorService.submit(new CallableEx(i)).get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }

}