package hw2.task2;

import java.util.ArrayList;
import java.util.concurrent.*;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            results.add(executorService.submit(new CallableBarsik(i)));
        }

        for (Future<String> fs : results) {
            try{
                System.out.println(fs.get(5, TimeUnit.MILLISECONDS));
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                e.printStackTrace();
            } finally {
                executorService.shutdown();
            }
        }
    }
}
