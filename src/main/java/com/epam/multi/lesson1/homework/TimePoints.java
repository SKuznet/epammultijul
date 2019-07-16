package com.epam.multi.lesson1.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TimePoints implements Runnable {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void run() {
        getLightColors();
    }

    private synchronized void getLightColors(){
        int[] periodsOfTime = new int[3];

        try {
            for (int i = 0; i<3; i++){
                System.out.println(Thread.currentThread() + " enter one integer (time in minute):");
                String line;
                if (!((line = reader.readLine()) == null)){
                        periodsOfTime[i] = Integer.parseInt(line);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        new TrafficLight().getLightColorsByTimePoints(periodsOfTime);
        System.out.println();
    }
}
