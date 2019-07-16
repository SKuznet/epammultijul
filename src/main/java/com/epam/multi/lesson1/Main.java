package com.epam.multi.lesson1;

public class Main {
    public static void main(String[] args) {

        int[] lightDurations = {3_000, 1_000, 2_000}; // red, yellow, green
        long referencePoint = 10_000;

        LightsFactory lightsFactory = new LightsFactory(lightDurations);

        Light red = lightsFactory.getRed();
        Light yellow = lightsFactory.getYellow();
        Light green = lightsFactory.getGreen();

        LightStatus lightStatus = new LightStatus(red, referencePoint);

        ThreadsFactory threadsFactory = new ThreadsFactory(red, yellow, green, lightStatus);

        LightThread threadRed = threadsFactory.getThreadRed();
        LightThread threadYellow = threadsFactory.getThreadYellow();
        LightThread threadGreen = threadsFactory.getThreadGreen();


        threadRed.start();
        threadYellow.start();
        threadGreen.start();

        try {
            threadRed.join();
            threadYellow.join();
            threadGreen.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Light in the end is " + lightStatus.getColour());
    }

}



