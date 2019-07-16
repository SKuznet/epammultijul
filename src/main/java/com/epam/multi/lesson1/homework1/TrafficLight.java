package com.epam.multi.lesson1.homework1;

public class TrafficLight implements Runnable {

    private int time;

    /**
     * @param time set time to show light
     */
    TrafficLight(int time) {
        this.time = time;
    }

    public void run() {
        System.out.println("Color: " + showColor() + " at " + time + " min; " + Thread.currentThread().getName());
    }

    /**
     * @return traffic light light
     */
    String showColor() {
        int timeShow = time % 10;
        Light light;
        if (timeShow <= 2) {
            light = Light.RED;
        } else if (timeShow <= 5) {
            light = Light.YELLOW;
        } else light = Light.GREEN;

        return light.getColor();
    }
}
