package hw1;

import hw1.enums.Light;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;

public class TrafficLight implements Callable<String> {
    private Light green;
    private Light yellow;
    private Light red;
    private int minute;
    private Map<Light, Predicate<Integer>> lightPredicateMap;

    public TrafficLight(int minute) {
        this.green = Light.GREEN;
        this.yellow = Light.YELLOW;
        this.red = Light.RED;
        this.minute = minute % 9;
        this.lightPredicateMap = initialize();
    }

    private Map<Light, Predicate<Integer>> initialize() {
        Map<Light, Predicate<Integer>> map = new HashMap<>();
        map.put(green, x -> x > 5);
        map.put(yellow, x -> x > 2 && x < 6);
        map.put(red, x -> x < 3);
        return map;
    }

    @Override
    public String call() throws Exception {
        AtomicReference<Light> color = new AtomicReference<>();
        lightPredicateMap.forEach((light, predicate) -> {
            if (predicate.test(minute))
                color.set(light);
        });
        return minute + " " + color.get().toString();
    }
    
}
