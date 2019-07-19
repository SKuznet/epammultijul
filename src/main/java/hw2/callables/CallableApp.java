package hw2.callables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableApp {

    public static void main(String[] args) {
        final List<Future<String>> futures = new ArrayList<>();
        final ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            futures.add(executorService.submit(new SloppyStringGenerator()));
        }

        futures.forEach(future -> System.out.println("Is This Future Done Already? " + future.isDone()));
        futures.forEach(future -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        futures.forEach(future -> System.out.println("Is This Future Done Already? " + future.isDone()));

        executorService.shutdown();
    }
}
