package hw1;

import hw1.enums.Light;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

public class TrafficLight implements Callable<String> {
    private Light green;
    private Light yellow;
    private Light red;
    private int minute;
    private Set<Light> lightPredicateMap;

    public TrafficLight(int minute) {
        this.green = Light.GREEN;
        this.yellow = Light.YELLOW;
        this.red = Light.RED;
        this.minute = minute % 9;
    }

    @Override
    public String call() throws Exception {
        AtomicReference<Light> color = new AtomicReference<>();
        if (minute > 5){
            color.set(green);
        } else if (minute > 2){
            color.set(yellow);
        } else if (minute >= 0){
            color.set(red);
        } else {
            throw new Exception("wrong minute value");
        }
        return minute + " " + color.get().toString();
    }
    
}
