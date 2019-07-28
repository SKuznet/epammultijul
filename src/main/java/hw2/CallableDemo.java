package hw2;

import java.util.ArrayList;
import java.util.concurrent.*;

public class CallableDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            results.add(executorService.submit(new CastSpellCallable(i)));
        }

        for (Future<String> result : results) {
            try {
                System.out.println(result.get(10, TimeUnit.MILLISECONDS));
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                e.printStackTrace();
            } finally {
                executorService.shutdown();
            }
        }

    }

}
