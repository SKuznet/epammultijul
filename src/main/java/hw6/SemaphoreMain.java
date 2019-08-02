package hw6;

import hw7.Conditional.CatState;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreMain {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new RunnableCatThread(semaphore, CatState.HUNGRY));
        executorService.execute(new RunnableCatThread(semaphore, CatState.HUNGRY));
        executorService.execute(new RunnableCatThread(semaphore, CatState.HUNGRY));
        executorService.shutdown();
    }
}

