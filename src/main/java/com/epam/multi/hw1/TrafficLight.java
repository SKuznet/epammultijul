package com.epam.multi.hw1;

public class TrafficLight {
    static final int RED_TIME = 2;
    static final int YELLOW_TIME = 3;
    static final int GREEN_TIME = 5;
    static final int FULL_CYCLE_TIME = RED_TIME + YELLOW_TIME + GREEN_TIME;

    public static Color getColorAfterTime(int minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("Minutes cant be negative.");
        }
        int modMinutes = minutes % FULL_CYCLE_TIME;
        Color result = Color.RED;
        if (modMinutes < RED_TIME) {
            result = Color.RED;
        } else if (modMinutes < RED_TIME + YELLOW_TIME) {
            result = Color.YELLOW;
        } else if (modMinutes < RED_TIME + YELLOW_TIME + GREEN_TIME) {
            result = Color.GREEN;
        } else {
            throw new IllegalArgumentException("Wrong argument value");
        }
        return result;
    }

    public enum Color {
        RED,
        YELLOW,
        GREEN
    }
}
