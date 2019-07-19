package hw2.callables;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class SloppyStringGenerator implements Callable<String> {

    @Override
    public String call() {
        return getMessage();
    }

    private String getMessage() {
        simulateCalculations(5, TimeUnit.SECONDS);
        return String.format("Hi! I'm from thread %s", Thread.currentThread().getName());
    }

    private void simulateCalculations(int duration, TimeUnit unit) {
        try {
            unit.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
