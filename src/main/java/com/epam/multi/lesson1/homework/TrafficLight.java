package com.epam.multi.lesson1.homework;

/**
 *Class provides traffic light behavior
 */
public class TrafficLight {

    /**
     * Method print light colors in time points
     * @param timePoints
     */
    public void getLightColorsByTimePoints (int[] timePoints){
        LightColor lightColor = LightColor.RED;
        int biggestPoint = biggest(timePoints);
        int red = 0;
        int yellow = 0;
        int green = 0;
        LightColor[] colorsInThisPeriod = new LightColor[biggestPoint];

        for (int i = 0; i<biggestPoint; i++){
            switch (lightColor){
                case RED:{
                    if(red < 2){
                        colorsInThisPeriod[i] = lightColor;
                        ++red;
                    } else {
                        lightColor = LightColor.YELLOW;
                        colorsInThisPeriod[i] = lightColor;
                        red = 0;
                        ++yellow;
                    }
                }
                break;
                case YELLOW:{
                    if(yellow < 3){
                        colorsInThisPeriod[i] = lightColor;
                        ++yellow;
                    } else {
                        lightColor = LightColor.GREEN;
                        colorsInThisPeriod[i] = lightColor;
                        yellow = 0;
                        ++green;
                    }
                }
                break;
                case GREEN:{
                    if(green < 2){
                        colorsInThisPeriod[i] = lightColor;
                        ++green;
                    } else {
                        lightColor = LightColor.RED;
                        colorsInThisPeriod[i] = lightColor;
                        green = 0;
                        ++red;
                    }
                }
                break;
            }
        }

        for (int i = 0; i<timePoints.length; i++){
            System.out.print(timePoints[i] + "=" + colorsInThisPeriod[timePoints[i]-1] + " ");
        }

    }

    /**
     * Method return biggest integer in array
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
