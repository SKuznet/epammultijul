package com.epam.multi.homeworks.homework1;

public class Main {
    public static void main(String[] args) {
        int[] seconds = new int[]{11, 4, 9};
        for (int i = 0; i < seconds.length; i++) {
            TrafficLight trafficLight = new TrafficLight(seconds[i]);
            Thread thread = new Thread(trafficLight);
            thread.start();
        }
    }
}
