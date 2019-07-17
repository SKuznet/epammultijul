package com.epam.multi.lesson1.homework1;

public class TrafficLight {

    public Lights checkLight(int inputTime){
        int time = inputTime % 9;

        if((time>=1)&&(time<=2)) {
            return Lights.RED;
        } else if ((time>=3)&&(time<=5)) {
            return Lights.YELLOW;
        } else if (((time>=6)&&(time<=8))||(time == 0)) {
            return Lights.GREEN;
        }
        return Lights.TRAFFICLIGHTISBROKEN;
    }
}
