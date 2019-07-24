package com.epam.multi.lesson4;

import java.io.IOException;

public class VolatileEx {

    private static volatile boolean flag = true;

    public static void main(String[] args) {
        new ThreadFlaggSetter().start();
        new ThreadFlagReader().start();
    }

    public static class ThreadFlagReader extends Thread {
        @Override
        public void run() {
            System.err.println("waiting...");

            while (flag) {

            }

            System.err.println("Gogogo");
        }
    }

    public static class ThreadFlaggSetter extends Thread {
        @Override
        public void run() {
            try {
                int value = System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }

            flag = false;

            System.err.println("Flag is down now");
        }
    }
}
