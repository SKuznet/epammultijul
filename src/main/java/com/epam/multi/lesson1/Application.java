package com.epam.multi.lesson1;

import com.epam.multi.lesson1.entities.TrafficLight;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

/**
 * Main runnable class
 */
public class Application {

    final static Logger logger = LogManager.getLogger(Application.class);
    final static TrafficLight trafficLight = new TrafficLight();

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Set minutes for traffic light (RYG) separated by space:");
            String buffer = br.readLine();
            String[] minutes = buffer.trim().split(" ");

            startThreads(minutes);

            for (int i = 0; i < 100; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("Current color of traffic light is " + trafficLight.getCurrentColor());
                } catch (InterruptedException e) {
                    logger.warn("Cannot parse the light color " + e);
                }
            }
        } catch (Exception e) {
            logger.error("Invalid entry " + e);
        }
    }

    /**
     * Method starts 3 color threads and trafficLight thread
     *
     * @param minutes custom strings from BufferedReader input separated by space
     */
    public static void startThreads(String[] minutes) {

        Thread redColorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                trafficLight.setRedLightMinutes(Integer.parseInt(minutes[0]));
            }
        });

        Thread yellowColorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                trafficLight.setYellowLightMinutes(Integer.parseInt(minutes[1]));
            }
        });

        Thread greenColorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                trafficLight.setGreenLightMinutes(Integer.parseInt(minutes[2]));
            }
        });

        redColorThread.start();
        yellowColorThread.start();
        greenColorThread.start();

        try {
            TimeUnit.SECONDS.sleep(1);
            trafficLight.start();
        } catch (InterruptedException e) {
            logger.warn(e);
        }
    }
}
