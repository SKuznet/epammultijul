package hw5.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {
        int countDown = 20;
        CountDownLatch countDownLatch = new CountDownLatch(countDown);
        System.out.println("Start count sheep");
        new SheepCounter(countDownLatch, countDown);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Finished. You should have been slept to this moment");
    }
}
