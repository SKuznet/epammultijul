package com.epam.multi.lesson4;

import java.io.IOException;

public class VolatileEx {
    private  static boolean flag = true;

    public static void main(String[] args) {
        new ThreadFlagSetter().start();
        new ThreadFlagReader().start();
    }

    public static class ThreadFlagReader extends Thread {
        @Override
        public void run() {
            System.err.println("waiting...");

            while(flag){

            }

            System.err.println("Goooo");
        }
    }

    public static class ThreadFlagSetter extends Thread {
        @Override
        public void run() {
            try {
                int value = System.in.read();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
