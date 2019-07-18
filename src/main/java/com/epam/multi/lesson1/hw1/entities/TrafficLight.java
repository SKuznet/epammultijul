package com.epam.multi.lesson1.hw1.entities;


public class TrafficLight extends Thread {

    private static Colors color;

    public static void currentColor() {
        System.out.println("Now " + color);
    }

    public static void sleepTime(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void setColor(String color) {
        TrafficLight.color = Colors.valueOf(color.toUpperCase());
    }


}
