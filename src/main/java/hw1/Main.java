package main.java.hw1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Integer> schedule = new ArrayList<>();
    private static int size;
    private static int count = 0;
    private static TrafficLight trafficLight;

    public static void main(String[] args) {

        consoleReader();
        size = schedule.size();
        trafficLight = new TrafficLight(2, 3, 4);
        Thread thread_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count<size) {
                    showLight();
                    count++;
                }
            }
        });
        Thread thread_2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count<size) {
                    showLight();
                    count++;
                }
            }
        });
        Thread thread_3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count<size) {
                    showLight();
                    count++;
                }
            }
        });

        thread_1.start();
        thread_2.start();
        thread_3.start();


    }


    public static void consoleReader() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String s = bufferedReader.readLine();
                if (s.isEmpty()) {
                    break;
                } else {
                    schedule.add(Integer.parseInt(s));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static synchronized void showLight() {
        trafficLight.findLight(schedule.get(count));
    }
}
