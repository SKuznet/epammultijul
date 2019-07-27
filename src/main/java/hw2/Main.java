package hw2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Priority part: ");
        ExecutorService priorityExecutorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 2; i++) {
            priorityExecutorService.execute(new PriorityTasks(Thread.MAX_PRIORITY));
        }
        for (int i = 0; i <2; i++) {
            priorityExecutorService.execute(new PriorityTasks(Thread.MIN_PRIORITY));
        }
        priorityExecutorService.shutdown();

        System.out.println("Callable part: ");
        List<Future<String>> futureList = new ArrayList<>();
        ExecutorService callableExecutorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            futureList.add(callableExecutorService.submit(new SomeThreadWithResult()));
        }

        for (Future<String> stringFuture : futureList) {
            try {
                System.out.println(stringFuture.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        callableExecutorService.shutdown();

    }

}
