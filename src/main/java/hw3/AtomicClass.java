package hw3;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicClass implements Runnable {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.err.println("Exit");
                System.exit(0);
            }
        }, 3000);

        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicClass atomicIntegerExample = new AtomicClass();
        executorService.execute(atomicIntegerExample);

        while (true) {
            int val = atomicIntegerExample.getValue();

            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }

    public int getValue() {
        return atomicInteger.get();
    }

    private void evenIncrement() {
        atomicInteger.addAndGet(2);
    }

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }
}