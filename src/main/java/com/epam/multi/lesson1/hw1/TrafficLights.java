package com.epam.multi.lesson1.hw1;

import java.util.concurrent.TimeUnit;

public class TrafficLights implements Runnable {

    private Thread green;
    private Thread yellow;
    private Thread red;
    private int greenTime;
    private int yellowTime;

    public TrafficLights(int greenTime, int yellowTime, int redTime) {
        this.greenTime = greenTime;
        this.yellowTime = yellowTime;
        green = new Thread(Light.GREEN.setTime(greenTime, yellowTime + redTime), Light.GREEN.name());
        yellow = new Thread(Light.YELLOW.setTime(yellowTime, redTime + greenTime), Light.YELLOW.name());
        red = new Thread(Light.RED.setTime(redTime, greenTime + yellowTime), Light.RED.name());
    }

    public void run() {
        try {
            green.start();
            TimeUnit.SECONDS.sleep(greenTime);
            yellow.start();
            TimeUnit.SECONDS.sleep(yellowTime);
            red.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets name of current light
     *
     * @return name of enum current
     */
    public String getLight() {
        return getCurrent().getName();
    }

    /**
     * Turns off all lights
     */
    public void shutdown() {
        green.interrupt();
        yellow.interrupt();
        red.interrupt();
    }

    private Thread getCurrent() {
        return green.getState().equals(Thread.State.WAITING) ? green
                : yellow.getState().equals(Thread.State.WAITING) ? yellow
                : red.getState().equals(Thread.State.WAITING) ? red
                : null;
    }
}
