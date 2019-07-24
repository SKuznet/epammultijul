package com.epam.multi.hw1;

public enum TrafficSignal {
    RED(2),
    YELLOW(3),
    GREEN(4);

    private int time;
    public static int FULL_CYCLE = RED.time + YELLOW.time + GREEN.time;

    TrafficSignal(int time){
        this.time = time;
    }

    public int getTime() {
        return time;
    }
}
