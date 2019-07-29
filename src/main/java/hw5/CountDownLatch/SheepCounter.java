package hw5.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class SheepCounter implements  Runnable {
    private CountDownLatch latch;
    private int sheepAmount;

    public SheepCounter(CountDownLatch latch, int sheepAmount) {
        this.latch = latch;
        this.sheepAmount = sheepAmount;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 1; i <= sheepAmount; i++) {
            System.out.println("Sheep number ... " + i);
            try {
                TimeUnit.MILLISECONDS.sleep(500);
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
