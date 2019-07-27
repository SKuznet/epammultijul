package com.epam.multi.lesson1.hw1;


import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String... args) {

        int[] timeLight = {2, 1, 2};

        final TrafficLight trafficLight = new TrafficLight(timeLight);
        trafficLight.run();

    }
}
