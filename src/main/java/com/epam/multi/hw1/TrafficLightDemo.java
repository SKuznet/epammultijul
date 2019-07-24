package com.epam.multi.hw1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class TrafficLightDemo {
    private final static int NUMBER_OF_THREADS = 3;
    private TrafficLight trafficLight = new TrafficLightImpl();

    public void showTrafficLights(int ... minutes) {
        AtomicInteger atomicIndex = new AtomicInteger(0);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int index;
                while ((index = atomicIndex.getAndIncrement()) < minutes.length) {
                    int minute = minutes[index];
                    TrafficSignal trafficSignal = trafficLight.getTrafficSignal(minute);
                    System.out.println("thread = " + Thread.currentThread().getName() +
                            "minute = " + minute + ", light = " + trafficSignal);
                }
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        for (int i = 0; i < NUMBER_OF_THREADS; i++){
            executorService.execute(runnable);
        }
        executorService.shutdown();
    }

    public static void main(String[] args) {
        TrafficLightDemo trafficLightDemo = new TrafficLightDemo();
        trafficLightDemo.showTrafficLights(1, 2, 3, 4, 5, 8, 9, 10, 11, 12, 13, 14, 17, 18, 19, 20);
    }
}
