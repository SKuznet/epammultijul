package com.epam.multi.homeWorks.hw1;

public class Main {
    public static void main(String[] args) {
        final TrafficLight trafficLight = new TrafficLight();

        Thread thread1 = new Thread(new TrafficLightColorGetterRunnable(trafficLight, 6));
        Thread thread2 = new Thread(new TrafficLightColorGetterRunnable(trafficLight, 43));
        Thread thread3 = new Thread(new TrafficLightColorGetterRunnable(trafficLight, 543552346));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
