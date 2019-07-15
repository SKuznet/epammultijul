package com.epam.multi.lesson1;

public class GlassBarsik implements Runnable {
    public void run() {
        System.out.println("I am Barsik from another Thread implements Runnable! " + Thread.currentThread().getName());
    }
}
