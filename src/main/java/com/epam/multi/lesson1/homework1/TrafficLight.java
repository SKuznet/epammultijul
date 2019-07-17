package com.epam.multi.lesson1.homework1;

/**
 * Class TrafficLight
 * @author Vladimir Magerov
 * @version 0.1
 */

public class TrafficLight {

    /**
     * Method for checking the current TrafficLight color
     * @param inputTime - input time to check it with TrafficLight
     * @return TrafficLight color
     */
    public Lights checkLight(int inputTime){
        int time = inputTime % 9;

        if((time>=1)&&(time<=2)) {
            return Lights.RED;
        } else if ((time>=3)&&(time<=5)) {
            return Lights.YELLOW;
        } else if (((time>=6)&&(time<=8))||(time == 0)) {
            return Lights.GREEN;
        }
        return Lights.WRONGINPUT;
    }
}
