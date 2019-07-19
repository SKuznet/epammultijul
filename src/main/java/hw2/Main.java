package hw2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        JournalistRun runFirst = new JournalistRun(1);
        JournalistRun runSecond = new JournalistRun(2);

        Thread firstThread = new Thread(runFirst);
        firstThread.setPriority(Thread.MAX_PRIORITY);
        Thread secondThread = new Thread(runSecond);
        secondThread.setPriority(Thread.MIN_PRIORITY);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(secondThread);
        executorService.submit(firstThread);

        executorService.shutdown();
    }

}
