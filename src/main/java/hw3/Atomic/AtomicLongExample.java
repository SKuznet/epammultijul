package hw3.Atomic;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongExample implements Runnable {
    private AtomicLong atomicLong = new AtomicLong();

    private long getValue(){
        return atomicLong.get();
    }

    private void evenIncrement(int delta){
        atomicLong.addAndGet(delta);
    }

    @Override
    public void run() {
        while(true){
            Random random = new Random();
            int delta = random.nextInt();
            if (delta > 0){
                evenIncrement(delta);
            }
        }
    }

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.err.println("Aborting");
                System.exit(0);
            }
        },5000);

        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicLongExample atomicLongExample = new AtomicLongExample();
        executorService.execute(atomicLongExample);

        while(true){
            long value = atomicLongExample.getValue();

            if (value % 2 != 0){
                System.out.println("Found odd value: " + value);
                System.exit(0);
            }
        }
    }
}
