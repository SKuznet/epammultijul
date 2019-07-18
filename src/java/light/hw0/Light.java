package light.hw0;

import light.hw0.enums.State;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Light implements Runnable {
    final private Logger lightLogger = LogManager.getLogger(Light.class);
    final private Map<Integer, State> map;

    private State state;
    private int sleepTime;
    private int minute;

    public Light(int minute, int sleepTime) {
        this.sleepTime = sleepTime;
        this.minute = minute;
    }

    {
        map = new HashMap<>();
        map.put(0, State.RED);
        map.put(1, State.RED);
        map.put(2, State.YELLOW);
        map.put(3, State.YELLOW);
        map.put(4, State.YELLOW);
        map.put(5, State.GREEN);
        map.put(6, State.GREEN);
        map.put(7, State.GREEN);
        map.put(8, State.GREEN);
    }

    @Override
    public void run() {
        lightLogger.info("In 'Run()' method");
        sleep();
        state = (map.get(minute % 9));
        lightLogger.warn("I woke up and my answer is: The light will be " + state + " after " + minute + " minutes.");
    }

    private void sleep() {
        try {
            lightLogger.info("I'm going to sleep for " + sleepTime / 1000 + " seconds");
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            lightLogger.error("Thread.sleep() is broken");
        }
    }
}