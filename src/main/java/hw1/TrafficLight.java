package hw1;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

class TrafficLight {

    private int fullCycleDuration = Arrays.stream(LightColors.values()).mapToInt(LightColors::getDuration).sum();

    LightColors getCurrentLightColor(int time) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int normalizedTime = getNormalizedTime(time);

        final LightColors result;
        if (isRed(normalizedTime)) {
            result = LightColors.RED;
        } else if (isYellow(normalizedTime)) {
            result = LightColors.YELLOW;
        } else {
            result = LightColors.GREEN;
        }
        return result;
    }

    private boolean isYellow(int normalizedTime) {
        return normalizedTime < LightColors.RED.getDuration() + LightColors.YELLOW.getDuration();
    }

    private boolean isRed(int normalizedTime) {
        return normalizedTime < LightColors.RED.getDuration();
    }

    private int getNormalizedTime(int time) {
        return time % fullCycleDuration;
    }
}
