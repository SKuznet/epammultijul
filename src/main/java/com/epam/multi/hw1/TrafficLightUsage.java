package com.epam.multi.hw1;

import java.util.Scanner;

public class TrafficLightUsage {
    public static void main(String[] args) {
        System.out.println("Enter the minute for which you want to get the " +
                "color of the traffic light or 'exit'.");
        Scanner keyboard = new Scanner(System.in);

        String inputLine = keyboard.nextLine();
        while (!inputLine.equals("exit")) {
            try {
                int enteredMinutes = Integer.parseInt(inputLine);
                System.out.println(TrafficLight.getColorAfterTime(enteredMinutes));
            } catch (NumberFormatException e) {
                System.err.println("Enter correct minute or 'exit'");
            } catch (IllegalArgumentException e) {
                System.err.println("Minutes cant be negative");
            }
            inputLine = keyboard.nextLine();
        }
    }
}
