package main.java.hw1;

public class TrafficLightColorChooser {
    private static int FULL_CYCLE_DURATION = 9;

    public static LightColor getLightColor(int enteredMinute) {
        int tmp = enteredMinute % FULL_CYCLE_DURATION;

        if (tmp >= 0 && tmp < 2) {
            return LightColor.RED;
        } else if (tmp >= 2 && tmp < 5) {
            return LightColor.YELLOW;
        } else {
            return LightColor.GREEN;
        }

    }

}
