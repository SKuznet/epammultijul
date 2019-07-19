package hw2.task1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Barsik implements Runnable {
    protected int viskasAmount = 20;
    private volatile double d;
    private int priority;

    public Barsik(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Barsik name :" + Thread.currentThread() + ":" + "viskasAmount=" + viskasAmount + ", priority=" + priority;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);

        while (true){
            for (int i = 0; i < 100000; i++) {
                d += (Math.PI + Math.E) / (double) i;

                if (i % 1000 == 0){
                    Thread.yield();
                }
            }
            System.out.println(this);

            if (--viskasAmount == 0){
                System.out.println("NOTICE: There is no viskas left :(");
                return;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Barsik(Thread.MAX_PRIORITY));

        for (int i = 0; i < 5 ; i++) {
            executorService.execute(new Barsik(Thread.MIN_PRIORITY));
        }

        executorService.shutdown();
    }
}
