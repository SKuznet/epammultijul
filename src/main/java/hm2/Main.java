package main.java.hm2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

    ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {

            executorService.execute(new RunnableClass());
        }
        executorService.shutdown();
    }
}
