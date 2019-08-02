package hw6;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class Cleaner implements Runnable {

    private Exchanger<Car> exchanger;
    private Car car;

    public Cleaner(Exchanger<Car> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            car = exchanger.exchange(new Car());
            System.err.println("Cleaning...");
            TimeUnit.MILLISECONDS.sleep(1000);
            car.setCleaned(true);
            System.err.println("----------------------");
            System.err.println("Cleaning complete");
            System.err.println("----------------------");
            System.err.println("Car status:");
            System.err.println(car.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}