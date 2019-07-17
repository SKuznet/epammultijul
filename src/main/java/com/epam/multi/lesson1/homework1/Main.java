package com.epam.multi.lesson1.homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) {
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
            TrafficLightCheck check0 = new TrafficLightCheck(inputMinutes[0]);
            TrafficLightCheck check1 = new TrafficLightCheck(inputMinutes[1]);
            TrafficLightCheck check2 = new TrafficLightCheck(inputMinutes[2]);
            new Thread(check0).start();
            new Thread(check1).start();
            new Thread(check2).start();
        }
        catch (NumberFormatException ex){
            System.out.println("Wrong number format, try again...");
        }
        catch (IOException ex) {
            System.out.println("You broke System.in...");
        }

    }
}
