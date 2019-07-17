package com.epam.multi.lesson1.homework;

public class Main {
    public static void main(String[] args) {
        TrafficLightThread timePoints = new TrafficLightThread();
        new Thread(timePoints).start();
        new Thread(timePoints).start();
        new Thread(timePoints).start();
    }
}
