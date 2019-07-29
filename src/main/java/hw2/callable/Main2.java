package main.java.hm2.callable;

import java.util.concurrent.*;

public class Main2 {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            Callable<String> callable = new CallableClass();
            Future<String> stringFuture = service.submit(callable);
            try {
                String text = stringFuture.get();
                System.out.println(text);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        service.shutdown();
    }
}
