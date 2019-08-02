package hw6;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Welder implements Runnable {

    private Semaphore semaphore;
    private CountDownLatch countDownLatch;
    private Exchanger<Car> exchanger;
    private Car car;


    public Welder(Semaphore semaphore, Car car) {
        this.semaphore = semaphore;
        this.car = car;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.err.println(Thread.currentThread().getName() + " welding...");
            TimeUnit.MILLISECONDS.sleep(1000);
            car.incrementWeldCount();
            System.err.println("weldCount is now " + car.getWeldCount());
            if (car.getWeldCount() == 3) {
                System.err.println("----------------------");
                System.err.println("Welding complete.");
            } else {
                System.err.println("Handover to next welder...");
            }
            if (car.getWeldCount() == 3) {
                car.setWelded(true);
            }
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}