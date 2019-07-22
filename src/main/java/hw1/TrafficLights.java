package main.java.hw1;

import java.util.List;

public class TrafficLights{

    private int green;
    private int yellow;
    private int red;
    private int workingtime;

    public TrafficLights(int green, int yellow, int red) {
        this.green = green;
        this.yellow = yellow;
        this.red = red;
        workingtime = green+yellow+red;
    }

    public void getLight(List<Integer> schedule) {
        for (Integer minute : schedule) {
            int lightTime = minute%workingtime;
            switch (lightTime) {
                case 2: turnOnGreen();
                case 5: turnOnYellow();
                case 9: turnOnRed();
                default: throw new IllegalArgumentException();
            }
        }
    }

    private void turnOnGreen() {
        System.out.println(Light.GREEN);
    }

    private void turnOnYellow(){
        System.out.println(Light.YELLOW);
    }

    private void turnOnRed() {
        System.out.println(Light.RED);
    }
}
