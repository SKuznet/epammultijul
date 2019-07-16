package com.epam.multi.lesson1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            final Thread thread = new Thread(new Runnable() {
                public void run() {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                        String input = bufferedReader.readLine();
                        Integer time = Integer.valueOf(input);
                        System.out.println("In " + time + " minute color is " + Service.getColor(time) + " says " + Thread.currentThread().getName());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
            thread.yield();
        }
    }
}