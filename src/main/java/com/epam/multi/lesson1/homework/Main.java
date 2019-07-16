package com.epam.multi.lesson1.homework;

public class Main {
    public static void main(String[] args) {
        TimePoints timePoints = new TimePoints();
        new Thread(timePoints).start();
        new Thread(timePoints).start();
        new Thread(timePoints).start();
    }
}
