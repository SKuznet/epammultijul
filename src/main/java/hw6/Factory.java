package hw6;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Factory {

    private AtomicInteger product = new AtomicInteger(0);

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        Exchanger<AtomicInteger> exchanger = new Exchanger<>();





    }


}
