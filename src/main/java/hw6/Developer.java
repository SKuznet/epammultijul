package hw6;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Developer implements Callable<Boolean> {
    private CountDownLatch latch;
    private static int counter;
    private static Random random = new Random();

    public int getId() {
        return id;
    }


    private int id = counter++;

    public Developer(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public Boolean call() {
        try {
            System.out.println("Developer " + id + " ready to write code");
            latch.countDown();
            latch.await();
            System.out.println("Developer " + id + " started to write code");
            TimeUnit.MILLISECONDS.sleep(random.ints(100, 200).findFirst().getAsInt());
            return true;
        } catch (InterruptedException e) {
            System.err.println("Developer " + id + " hasn't finished to write code");
            return false;
        }
    }
}
