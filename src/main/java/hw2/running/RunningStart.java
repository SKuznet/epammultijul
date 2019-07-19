package hw2.running;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunningStart {
    public static void main(String[] args) {
        Running running1 = new Running(1);
        Running running2 = new Running(2);

        Thread thread = new Thread(running1);
        thread.setPriority(Thread.MAX_PRIORITY);

        Thread thread2 = new Thread(running2);
        thread2.setPriority(Thread.MIN_PRIORITY);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(thread);
        executorService.submit(thread2);
        executorService.shutdown();
    }
}
