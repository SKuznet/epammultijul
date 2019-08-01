package hw4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new AtomicIncrement(1));
        executorService.execute(new AtomicIncrement(2));
    }
}