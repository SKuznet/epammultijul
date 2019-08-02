package hw6;

import java.util.concurrent.TimeUnit;

public class Timekeeper implements Runnable {

    private Car car;
    private Object lock;

    public Timekeeper(Car car, Object lock) {
        this.car = car;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            if (car.getWeldCount() >= 3) {
                Thread.currentThread().interrupt();
            }
        }


    }
}
