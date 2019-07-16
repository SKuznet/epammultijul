package com.epam.multi.lesson1;

public class Light {

    private String colour;
    private int timeSeconds;

    Light(String colour, int timeSeconds) {
        this.colour = colour;
        this.timeSeconds = timeSeconds;
    }

    public String getColour() {
        return colour;
    }

    public int getTimeSeconds() {
        return timeSeconds;
    }

}
