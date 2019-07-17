package com.epam.multi.lesson1.hw1;

public class TrafficLightColorGetterRunnable implements Runnable {
    private int time;
    private TrafficLight trafficLight;

    public TrafficLightColorGetterRunnable(TrafficLight trafficLight, int time){
        this.time = time;
        this.trafficLight = trafficLight;
    }

    public void run() {
        TrafficLightColor trafficLightColor = trafficLight.getColorByTime(time);
        System.out.printf("My name is %s with set up time %d and traffic light's color is %s. \n", Thread.currentThread().getName(), time, trafficLightColor.toString());
    }
}
