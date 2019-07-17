package main.java.hw1;

public class TrafficLight {

    private int red;
    private int yellow;
    private int green;
    private int worktime;
    String light;


    public TrafficLight(int red, int yellow, int green) {
        this.red = red;
        this.yellow = yellow;
        this.green = green;
        worktime = red+yellow+green;
    }

    public synchronized void findLight(int count) {
        int minute = count%worktime;
        if (minute < red) {
            System.out.println("Red");
        }else if (minute < yellow) {
            System.out.println("Yellow");
        } else {
            System.out.println("Green");
        }

    }
}
