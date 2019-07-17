package com.epam.multi.lesson1.hw1;


import java.util.concurrent.TimeUnit;

public class TrafficLight implements Runnable {

    private LightColor lightColor;
    private int[] timeLight;

    public TrafficLight() {
    }

    public TrafficLight(int[] timeLight) {
        this.timeLight = timeLight;
    }

    @Override
    public void run() {

        while (true) {
            try {
                this.lightColor = LightColor.RED;
                System.out.println(this.lightColor);
                TimeUnit.SECONDS.sleep(timeLight[0]);
                this.lightColor = LightColor.YELLOW;
                System.out.println(this.lightColor);
                TimeUnit.SECONDS.sleep(timeLight[1]);
                this.lightColor = LightColor.GREEN;
                System.out.println(this.lightColor);
                TimeUnit.SECONDS.sleep(timeLight[2]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public LightColor getLightColor() {
        return lightColor;
    }

    public void setLightColor(LightColor lightColor) {
        this.lightColor = lightColor;
    }
}
