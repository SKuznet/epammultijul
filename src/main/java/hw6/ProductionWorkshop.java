package hw6;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ProductionWorkshop implements Runnable {

    private Semaphore semaphore;
    private CountDownLatch countDownLatch;
    private Item item;

    public ProductionWorkshop(Semaphore semaphore, CountDownLatch countDownLatch, Item item) {
        this.semaphore = semaphore;
        this.countDownLatch = countDownLatch;
        this.item = item;
    }

    @Override
    public void run() {

        try {
            semaphore.acquire();
            TimeUnit.MILLISECONDS.sleep(1000);







        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
