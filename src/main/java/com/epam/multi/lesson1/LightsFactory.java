package com.epam.multi.lesson1;

public final class LightsFactory {

    private final Light red;
    private final Light yellow;
    private final Light green;

    public LightsFactory(int[] lightsDurations) {
        if (LightsUtil.isLengthCorrect(lightsDurations) && LightsUtil.areDurationsCorrect(lightsDurations)) {
            red = new Light("Red", lightsDurations[0]);
            yellow = new Light("Yellow", lightsDurations[1]);
            green = new Light("Green", lightsDurations[2]);
        }
        else throw new RuntimeException("Illegal input light durations array");
    }

    public Light getRed() {
        return red;
    }

    public Light getYellow() {
        return yellow;
    }

    public Light getGreen() {
        return green;
    }
}
