package com.epam.multi.lesson1.hw1;

import com.epam.multi.lesson1.hw1.entities.TrafficLight;

public enum TrafficLightApp {
    INSTANCE;

    int[] timeOut = {2000, 3000, 4000};

    Thread thread1 = new Thread(new Runnable() {
        public void run() {
            TrafficLight.setColor("red");
            TrafficLight.currentColor();
            TrafficLight.sleepTime(timeOut[0]);
        }
    });

    Thread thread2 = new Thread(new Runnable() {
        public void run() {
            TrafficLight.sleepTime(timeOut[0] + timeOut[1]);
            TrafficLight.setColor("yellow");
            TrafficLight.currentColor();
        }
    });

    Thread thread3 = new Thread(new Runnable() {
        public void run() {
            TrafficLight.sleepTime(timeOut[0] + timeOut[1] + timeOut[2]);
            TrafficLight.setColor("green");
            TrafficLight.currentColor();
        }
    });

    public void startThreads() {
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
