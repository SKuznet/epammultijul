package com.epam.multi.lesson1;

public class MirrirBarsik extends Thread {
    @Override
    public void run() {
        System.out.println("I am Barsik from another Thread extend Thread... " + Thread.currentThread().getName());
    }
}
