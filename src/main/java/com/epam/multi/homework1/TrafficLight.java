package com.epam.multi.homework1;

import java.util.ArrayList;
import java.util.List;

/**
 * Class TrafficLight implements logic of working traffic light
 * */
public class TrafficLight extends Thread implements TrafficLightChanging {

    private List<String> light = new ArrayList<>();
    private int currentTime;

    {
        light.add("Red");
        light.add("Yellow");
        light.add("Green");
    }
    /**
     * Default constructor for creating Traffic light at 0 time
     * */
    public TrafficLight() {
        this.currentTime = 0;
    }

    /**
     * Constructor sets current time on given
     * @param time Time for setting
     * */
    TrafficLight(int time) {
        this.currentTime = time;
    }

    /**
     * Run method to show name of current thread and color
     * */
    public void run() {
        System.out.println("Thread name: " + Thread.currentThread().getName() + "; current light: " + currentLight());
    }

    /**
     * Method checks current time and calculating light of traffic
     * @return Current color of traffic lights
     * */
    @Override
    public String currentLight() {
        if (currentTime > 8) currentTime = currentTime % 8;

        if (currentTime >= 0 && currentTime < 2) return light.get(0);
        else if (currentTime >= 2 && currentTime < 5) return light.get(1);
        else return light.get(2);

    }

    /**
     * Method helps to get information about current time
     * */
    public int getCurrentTime() {
        return currentTime;
    }

    /**
     * Mthod helps to set current time if it wasn`t set during creation of traffic light object
     * */
    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }

    /**
     * @return hashcode of object
     * */
    @Override
    public int hashCode() {
        int result = light.hashCode();
        result = 31 * result + currentTime;
        return result;
    }

    /**
     * @return String look of object
     * */
    @Override
    public String toString() {
        return "Light {" +
                "time = " + currentTime + "}";
    }

}
