package com.epam.multi.lesson1.hm1.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Trafficlight extends Thread implements Beautifulable {

    private final static int COUNT_OF_TIME_REQUESTS = 3;
    private final static int MINUTES_IN_AN_HOUR = 60;
    private static Scanner scanner = new Scanner(System.in);
    private static List<Integer> timeList = new ArrayList<>();
    private Integer mate;

    public static void main(String[] args) {
        mainProgramCycle();
        scanner.close();
    }

    private static void mainProgramCycle() {
        while (true) {
            checkAndCorrectInputTime();

            for (Integer time : timeList) {
                Trafficlight thread = new Trafficlight();
                thread.mate = time;
                thread.run();
            }
        }
    }

    private static void checkAndCorrectInputTime() {
        String uncheckedInput;
        int resultCheckedInput;
        timeList.clear();

        while (timeList.size() != COUNT_OF_TIME_REQUESTS) {

            uncheckedInput = scanner.next();
            try {
                resultCheckedInput = Integer.parseInt(uncheckedInput);
                if (resultCheckedInput < 0) {
                    resultCheckedInput *= -1;
                }
                resultCheckedInput = resultCheckedInput >= MINUTES_IN_AN_HOUR ? resultCheckedInput % 60 : resultCheckedInput;
                timeList.add(resultCheckedInput);

            } catch (NumberFormatException e) {
                System.err.println("Incorrect input! ");
                timeList.clear();
            }
        }
    }

    @Override
    public void run() {

        int totalColorDelay = Color.GREEN.delay + Color.YELLOW.delay + Color.RED.delay;
        Color resultColor;

        switch (this.mate % totalColorDelay) {
            case 0:
            case 1:
                resultColor = Color.RED;
                break;
            case 2:
            case 3:
            case 4:
                resultColor = Color.YELLOW;
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                resultColor = Color.GREEN;
                break;
            default:
                resultColor = null;
        }

        beautifulOutput(resultColor);
    }

    public void beautifulOutput(Color color) {
        System.out.println("Its " + color + " color in " + getName());
    }
}
