package com.epam.multi.lesson1.homework;

/**
 *Class provides traffic light behavior
 */
public class TrafficLight {

    /**
     *
     * @param timePoints
     * @return
     */
    public void getLightColorsByTimePoints (int[] timePoints){
        LightColor lightColor = LightColor.RED;
        int biggestPoint = biggest(timePoints);
        int red = 0;
        int yellow = 0;
        int green = 0;
        LightColor[] colorsInThisPeriod = new LightColor[biggestPoint];

        for (int i = 0; i<biggestPoint; i++){
            if(lightColor.equals(LightColor.RED) && red < 2){
                colorsInThisPeriod[i] = lightColor;
                ++red;
            } else if(lightColor.equals(LightColor.RED)) {
                lightColor = LightColor.YELLOW;
                colorsInThisPeriod[i] = lightColor;
                red = 0;
                ++yellow;
            }

            if(lightColor.equals(LightColor.YELLOW) && yellow < 3){
                colorsInThisPeriod[i] = lightColor;
                ++yellow;
            } else if(lightColor.equals(LightColor.YELLOW)) {
                lightColor = LightColor.GREEN;
                colorsInThisPeriod[i] = lightColor;
                yellow = 0;
                ++green;
            }

            if(lightColor.equals(LightColor.GREEN) && green < 4){
                colorsInThisPeriod[i] = lightColor;
                ++green;
            } else if(lightColor.equals(LightColor.GREEN)) {
                lightColor = LightColor.RED;
                colorsInThisPeriod[i] = lightColor;
                green = 0;
                ++red;
            }
        }

        for (int i = 0; i<timePoints.length; i++){
            System.out.print(timePoints[i] + "=" + colorsInThisPeriod[timePoints[i]-1] + " ");
        }

    }

    /**
     *
     * @param ints
     * @return
     */
    private int biggest(int[] ints){
        int biggest = 0;
        for (int i = 0; i<ints.length; i++){
            if(ints[i] > biggest){
                biggest = ints[i];
            }
        }
        return biggest;
    }

}
