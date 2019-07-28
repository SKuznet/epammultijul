package hw2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableDemo {

    public static void main(String[] args) {
        ExecutorService  executorService = Executors.newCachedThreadPool();
        executorService.execute(new CastSpell(Thread.MIN_PRIORITY));
        executorService.execute(new CastSpell(Thread.MAX_PRIORITY));
    //    executorService.execute(new CastSpell(Thread.NORM_PRIORITY));
        executorService.shutdown();
    }

}
