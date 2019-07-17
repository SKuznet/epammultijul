package com.epam.multi.homework.hw1;

import java.util.concurrent.TimeUnit;

/**
 * Turns the appropriate light on for the specified amount of time
 */
public class TrafficLightOn extends Thread {

    int time;
    TrafficLightColor color;

    TrafficLightOn(int time, TrafficLightColor color) {
        this.time = time;
        this.color = color;
    }

    @Override
    public void run() {
        try {
            System.out.println("The current color is " + color);
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}