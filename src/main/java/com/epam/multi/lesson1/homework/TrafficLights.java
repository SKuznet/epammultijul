package com.epam.multi.lesson1.homework;


public class TrafficLights implements Runnable {

    private Light light;

    private enum Light {
        RED, YELLOW, GREEN
    }

    public Light getLight() {
        return light;
    }

    private void setLight(Light light) {
        this.light = light;
    }

    private void setLightByMinute(int minute) {

        if (minute > 0 && minute <= 2) {
            setLight(Light.RED);
        } else if (minute > 2 && minute <= 5) {
            setLight(Light.YELLOW);
        } else if (minute > 5 && minute <= 9) {
            setLight(Light.GREEN);
        }
    }

    public void run() {
        try {
            for (int i = 0; i < Time.time.length; i++) {
                Thread.sleep(1000);
                this.setLightByMinute(Time.time[i]);
            }
        } catch (InterruptedException e) {
            System.err.println("Ouch");
        }
    }
}
