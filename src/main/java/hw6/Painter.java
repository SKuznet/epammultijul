package hw6;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class Painter implements Runnable {

    private CountDownLatch countDownLatch;
    private Exchanger<Car> exchanger;
    private Car car;

    public Painter(CountDownLatch countDownLatch, Exchanger<Car> exchanger, Car car) {
        this.countDownLatch = countDownLatch;
        this.exchanger = exchanger;
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (car.getWeldCount() < 3) {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            for (int i = 0; i < 5; i++) {
                System.err.println(Thread.currentThread().getName() + " is painting...");
                car.incrementPaintCount();
                System.err.println("painCount is now " + car.getPaintCount());
                countDownLatch.countDown();
                TimeUnit.MILLISECONDS.sleep(500);
                if (car.getPaintCount() == 10) {
                    car.setPainted(true);
                    System.err.println("----------------------");
                    System.err.println("Painting complete.");
                    exchanger.exchange(car);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}