package com.epam.multi.lesson7.races.entities;

public class Finish {
    private static int count = 1;
    private static Object lock = new Object();


    public static int line(Horse horse) {
        synchronized (lock) {
            if (count == 1) {
                count--;
                return 1;
            } else {
                return 2;
            }
        }
    }
}
