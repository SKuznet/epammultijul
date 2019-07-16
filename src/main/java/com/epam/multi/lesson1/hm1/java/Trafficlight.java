package com.epam.multi.lesson1.hm1.java;

import java.util.Scanner;

public class Trafficlight extends Thread implements CorrectInputable {

    private final static int MINUTES_IN_AN_HOUR = 60;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Thread thread1 = new Trafficlight();
        Thread thread2 = new Trafficlight();
        Thread thread3 = new Trafficlight();

        mainProgramCycle();

        scanner.close();
    }

    private static void mainProgramCycle() {
        String uncheckedInput;
        int checkedInput;

        System.out.println("Press 'Y' for exit.");

        while (true) {
            uncheckedInput = scanner.next();

            if (uncheckedInput.contains("Y") || uncheckedInput.contains("y")) {
                break;
            } else {
                checkedInput = checkAndCorrectInputTime(uncheckedInput);
            }

            System.out.println(getСolorOfCorrespondingTime(checkedInput));

        }
    }

    private static Color getСolorOfCorrespondingTime(final int time) {
        int totalColorDelay = Color.GREEN.delay + Color.YELLOW.delay + Color.RED.delay;
        switch (time % totalColorDelay) {
            case 0:
            case 1:
                return Color.RED;
            case 2:
            case 3:
            case 4:
                return Color.YELLOW;
            case 5:
            case 6:
            case 7:
            case 8:
                return Color.GREEN;
            default:
                return null;
        }
    }

    private static int checkAndCorrectInputTime(String uncheckedInput) {
        int result = 0;

        while (true) {
            try {
                result = Integer.parseInt(uncheckedInput);
                if (result < 0) {
                    result *= -1;
                }
                break;
            } catch (NumberFormatException e) {
                System.err.println("Incorrect input! ");
                uncheckedInput = scanner.next();
            }
        }

        return result >= MINUTES_IN_AN_HOUR ? result % 60 : result;
    }

    @Override
    public void run() {

    }

    public int timeInput(int minute) {

        return 1;
    }
}
