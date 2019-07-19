package com.epam.multi.lesson1.homework;


public class Homework {

    public static void main(String[] args) {

        final TrafficLights trafficLights = new TrafficLights();
        Thread trafficLightsThread = new Thread(trafficLights);

        ThreadForTrafficLights threadForTrafficLights = new ThreadForTrafficLights(trafficLights, 2000);
        ThreadForTrafficLights threadForTrafficLights2 = new ThreadForTrafficLights(trafficLights, 5000);
        ThreadForTrafficLights threadForTrafficLights3 = new ThreadForTrafficLights(trafficLights, 8000);

        trafficLightsThread.start();
        threadForTrafficLights.startThread();
        threadForTrafficLights2.startThread();
        threadForTrafficLights3.startThread();
    }
}


