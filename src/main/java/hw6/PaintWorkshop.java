package hw6;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class PaintWorkshop implements Runnable{

    private Semaphore semaphore;
    private CountDownLatch countDownLatch;
    private Exchanger<AtomicInteger> exchanger;

    public PaintWorkshop(Semaphore semaphore, CountDownLatch countDownLatch, Exchanger<AtomicInteger> exchanger) {
        this.semaphore = semaphore;
        this.countDownLatch = countDownLatch;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {

    }
}
