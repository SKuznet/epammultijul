package hw2.calling;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallingStart {

    public static void main(String[] args) {
        CallingStart callingStart = new CallingStart();
        List<Calling> callings = Arrays.asList(new Calling(1), new Calling(2));
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        callingStart.printThreadReturnValue(callingStart.handleExceptions(callings, executorService));
        executorService.shutdown();
    }

    private List<Future<Integer>> handleExceptions(List<Calling> callings, ExecutorService executorService) {
        List<Future<Integer>> futures = null;
        try {
            futures = executorService.invokeAll(callings);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return futures;
    }

    private void printThreadReturnValue(List<Future<Integer>> futures) {
        try {
            System.out.println("Thread 1 returns: " + futures.get(0).get());
            System.out.println("Thread 2 returns: " + futures.get(1).get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
