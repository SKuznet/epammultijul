package hw1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        List<Integer> listOfParameters = new ArrayList<>();
        listOfParameters.add(2);
        listOfParameters.add(3);
        listOfParameters.add(4);

        final TrafficLight trafficLight = new TrafficLight();

        Thread threadForRed = new Thread(new Runnable() {
            @Override
            public void run() {
                trafficLight.setMinutesForRedLight(listOfParameters.get(0));
                System.out.println("Done setting red light duration on: " + Thread.currentThread().getName());
            }
        });

        Thread threadForYellow = new Thread(new Runnable() {
            @Override
            public void run() {
                trafficLight.setMinutesForYellowLight(listOfParameters.get(1));
                System.out.println("Done setting yellow light duration on: " + Thread.currentThread().getName());
            }
        });

        Thread threadForGreen = new Thread(new Runnable() {
            @Override
            public void run() {
                trafficLight.setMinutesForGreenLight(listOfParameters.get(2));
                System.out.println("Done setting green light duration on: " + Thread.currentThread().getName());
            }
        });

        threadForRed.start();
        threadForYellow.start();
        threadForGreen.start();

        trafficLight.start();

        for (int i = 0; i < 30; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Current color is: " + trafficLight.getCurrentColor());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
