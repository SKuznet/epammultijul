package main.java.hw1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Integer> minutes;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            minutes = new ArrayList<>();
            while (true) {
                String minute = reader.readLine();
                if (minute.isEmpty()) {
                    break;
                } else {
                    minutes.add(Integer.parseInt(minute));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        TrafficLights trafficLights = new TrafficLights(2,3,4);
        trafficLights.getLight(minutes);
    }
}
