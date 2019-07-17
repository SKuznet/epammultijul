package com.epam.multi.lesson1.hw1;

public class TrafficLight {

    public TrafficLightColor getColorByTime(int time) {
        time = getSimplerTime(time);

        if (time < 2) return TrafficLightColor.RED;
        if (time < 5) return TrafficLightColor.YELLOW;
        return TrafficLightColor.GREEN;
    }

    private int getSimplerTime(int time) {
        int fullCycleOfTrafficLight = 9;
        return time % fullCycleOfTrafficLight;
    }
}
