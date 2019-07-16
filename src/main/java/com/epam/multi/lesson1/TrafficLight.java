package main.java.com.epam.multi.lesson1;

import java.util.Map;

public class TrafficLight {

    Map<Integer, String> lightsByMinutes;
    int workingTime;

    TrafficLight() {

    }

    TrafficLight(int a, int b, int c) {
        workingTime = a+b+c;
        lightsByMinutes.put(a, "red");
        lightsByMinutes.put(b, "yellow");
        lightsByMinutes.put(c, "green");
    }

    public void showLight(int minute) {
        int minuteOfCycle = minute%workingTime;
        String light;
    }

}