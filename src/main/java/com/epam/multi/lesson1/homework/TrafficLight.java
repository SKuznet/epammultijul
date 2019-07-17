package com.epam.multi.lesson1.homework;

/**
 * Class provides traffic light behavior
 */
public class TrafficLight {

    /**
     * Method return light colors in array by time points
     *
     * @param timePoints
     * @return
     */
    public LightColor[] getLightColorsByTimePoints(int[] timePoints) {
        int biggestPoint = biggest(timePoints);
        int j = 0;
        LightColor[] colorsInThisPeriod = new LightColor[biggestPoint];
        LightColor[] colorsByTimePoints = new LightColor[timePoints.length];
        for (int i = 0; i < biggestPoint; i++) {
            if (j % 9 == 0) {
                j = 0;
            }

            if (j < 2) {
                colorsInThisPeriod[i] = LightColor.RED;
            } else if (j >= 2 && j < 5) {
                colorsInThisPeriod[i] = LightColor.YELLOW;
            } else {
                colorsInThisPeriod[i] = LightColor.GREEN;
            }
            j++;
        }

        for (int i = 0; i < timePoints.length; i++) {
            colorsByTimePoints[i] = colorsInThisPeriod[timePoints[i] - 1];
        }

        return colorsByTimePoints;
    }

    /**
     * Method return biggest integer in array
     *
     * @param ints
     * @return
     */
    private int biggest(int[] ints) {
        int biggest = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] > biggest) {
                biggest = ints[i];
            }
        }
        return biggest;
    }

}
