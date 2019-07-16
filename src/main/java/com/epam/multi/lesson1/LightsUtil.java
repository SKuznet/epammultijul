package com.epam.multi.lesson1;

public class LightsUtil {

    public static boolean isLengthCorrect(int[] lightsDurations) {
        return lightsDurations.length == 3;
    }

    public static boolean areDurationsCorrect(int[] lightsDurations) {
        boolean res = true;
        for (int i = 0; i < lightsDurations.length; i++) {
            res = res && (lightsDurations[i] > 0);
            if (!res) break;
        }
        return res;
    }

}
