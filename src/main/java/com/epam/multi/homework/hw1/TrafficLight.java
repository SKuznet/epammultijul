package com.epam.multi.homework.hw1;

import java.util.concurrent.TimeUnit;

/**
 * Starts a thread for a given light color and manages waiting for other threads
 */
public class TrafficLight extends Thread {
    private TrafficLightColor color;
    private int workTime;
    private int waitTime;

    public TrafficLight(TrafficLightColor color, int workTime, int waitTime) {
        this.color = color;
        this.workTime = workTime;
        this.waitTime = waitTime;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread thread = new TrafficLightOn(workTime, color);
                thread.start();
                thread.join();
                //thread.sleep(waitTime*1000);
                TimeUnit.SECONDS.sleep(waitTime);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
