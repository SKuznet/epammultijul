package hw2.runnables;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableApp {

    public static void main(String[] args) {
        final Counter minCounter = new Counter(Thread.MIN_PRIORITY);
        final Counter normCounter = new Counter(Thread.NORM_PRIORITY);
        final Counter maxCounter = new Counter(Thread.MAX_PRIORITY);

        System.out.println("Getting started");
        final ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(minCounter);
        executorService.submit(normCounter);
        executorService.submit(maxCounter);

        executorService.shutdown();
        System.out.println("Bye!");
    }
}
