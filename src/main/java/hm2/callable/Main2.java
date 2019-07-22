package main.java.hm2.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main2 {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            Callable<String> callable = new CallableClass();
            Future<String> stringFuture = service.submit(callable);
            System.out.println(stringFuture);
        }
        service.shutdown();
    }
}
