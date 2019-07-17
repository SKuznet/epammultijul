package com.epam.multi.homework.hw1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

// First draft, not final solution
public class Main {

    public static int[] getTimeLimitsFromUser() {
        int[] timeLimits = new int[3];
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter the time limits for Green, Yellow and Red lights: ");
            for (int i = 0; i < 3; i++) {
                while (true) {
                    try {
                        timeLimits[i] = Integer.valueOf(reader.readLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Wrong data type!");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return timeLimits;
    }

    public static void main(String[] args) {

        int[] timeLimits = getTimeLimitsFromUser();

        Thread greenLight = new TrafficLight(TrafficLightColor.GREEN, timeLimits[0], timeLimits[1] + timeLimits[2]);
        Thread yellowLight = new TrafficLight(TrafficLightColor.YELLOW, timeLimits[1], timeLimits[0] + timeLimits[2]);
        Thread redLight = new TrafficLight(TrafficLightColor.RED, timeLimits[2], timeLimits[0] + timeLimits[1]);

        try {
            greenLight.start();
            TimeUnit.SECONDS.sleep(timeLimits[0]);
            yellowLight.start();
            TimeUnit.SECONDS.sleep(timeLimits[1]);
            redLight.start();
            TimeUnit.SECONDS.sleep(timeLimits[2]);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
