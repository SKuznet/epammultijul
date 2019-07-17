package com.epam.multi.lesson1.hw1;


import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String... args) {

        int[] timeLight = {2, 1, 2};

        final TrafficLight trafficLight = new TrafficLight(timeLight);
        trafficLight.run();

        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.yield();
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " current traffic light is: " + trafficLight.getLightColor());

                }
            }).start();
        }
    }
}
