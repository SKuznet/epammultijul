package com.epam.multi.lesson1.hw1;

import java.util.concurrent.TimeUnit;

public class TrafficLights implements Runnable{

    private int greenTime;
    private int yellowTime;
    private int redTime;
    private Light current;

    public TrafficLights(int greenTime, int yellowTime, int redTime) {
        this.greenTime = greenTime;
        this.yellowTime = yellowTime;
        this.redTime = redTime;
    }

    public void run() {
        try {
            turnOnGreen();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets name of current light
     * @return name of enum current
     */
    public String getLight() {
        return current.name();
    }

    private void turnOnGreen() throws InterruptedException{
        current = Light.GREEN;
        TimeUnit.SECONDS.sleep(greenTime);
        waitForYellow();
    }

    private void waitForYellow() throws InterruptedException{
        current = Light.YELLOW;
        TimeUnit.SECONDS.sleep(yellowTime);
        waitForRed();
    }

    private void waitForRed() throws InterruptedException{
        current = Light.RED;
        TimeUnit.SECONDS.sleep(redTime);
        turnOnGreen();
    }
}
