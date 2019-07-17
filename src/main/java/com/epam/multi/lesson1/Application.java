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

    public static void main(String[] args) {
        final TrafficLight trafficLight = new TrafficLight();
        try (BufferedReader br = new BufferedReader (new InputStreamReader(System.in))){
            System.out.print ("Set minutes for traffic light (RYG) separated by space:");
            String[] minutes = br.readLine().trim().split(" ");

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
                trafficLight.run();
            } catch (InterruptedException e){
                logger.warn(e);
            }

            for (int i = 0; i < 100; i++) {
                try{
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("Current color of traffic light is " + trafficLight.getCurrentColor());
                } catch (InterruptedException e){
                    logger.warn("Cannot parse the light color " + e);
                }
            }

        } catch (Exception e) {
            logger.error("Invalid entry " + e);
        }
    }
}
