package com.epam.multi.lesson1.homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        final TrafficLight trafficLight = new TrafficLight();
        int[][] inputMinutes = new int[3][3];
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("Input time moments");
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println("Input time for thread " + i);
                for (int j = 0; j < 3; j++) {
                    inputMinutes[i][j] = Integer.parseInt(br.readLine());
                }
            }
        }
        catch (IOException ex) {
        }

        final TrafficLightCheck check0 = new TrafficLightCheck(inputMinutes[0]);
        final TrafficLightCheck check1 = new TrafficLightCheck(inputMinutes[1]);
        final TrafficLightCheck check2 = new TrafficLightCheck(inputMinutes[2]);
        Thread thread0 = new Thread(new Runnable() {
            public void run() {
                for(int i=0;i<3;i++) {
                    trafficLight.checkLight(check0.getMinutes()[i]);
                }
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                for(int i=0;i<3;i++) {
                    trafficLight.checkLight(check1.getMinutes()[i]);
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                for(int i=0;i<3;i++) {
                    trafficLight.checkLight(check2.getMinutes()[i]);
                }
            }
        });
        thread0.start();
        thread1.start();
        thread2.start();
    }
}
