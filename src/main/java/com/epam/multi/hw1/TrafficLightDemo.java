package com.epam.multi.hw1;

public class TrafficLightDemo {

    private TrafficLight trafficLight = new TrafficLightImpl();

    public static void main(String[] args){
        TrafficLightDemo trafficLightDemo = new TrafficLightDemo();
        int currentTime = 27;
        TrafficSignal trafficSignal = trafficLightDemo.trafficLight.getTrafficSignal(currentTime);
        System.out.println("Minute = " + currentTime + "; Light = " + trafficSignal);
    }
}
