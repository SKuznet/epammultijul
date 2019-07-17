package com.epam.multi.lesson1.homework1;

/**
 * Class TrafficLightCheck
 * @author Vladimir Magerov
 * @version 0.1
 */
public class TrafficLightCheck implements Runnable {
    /** Array of integer values (minutes) */
    private int[] minutes;
    /**
     * Constructor - creating a new object of TrafficLightCheck class
     * @param inputMinutes - input minutes array to check
     */
    public  TrafficLightCheck(int[] inputMinutes){
        minutes = inputMinutes;
    }
    /**
     * Method which implements actions that run in a separate thread
     */
    public void run() {
        TrafficLight trafficLight = new TrafficLight();
        for(int i=0;i<3;i++) {
            System.out.println(Thread.currentThread().getName() + " var " + minutes[i] + "  " + trafficLight.checkLight(minutes[i]));
        }
    }
}
