package com.epam.multi.lesson1;

import com.epam.multi.lesson1.entities.TrafficLight;
import org.junit.Test;


import static org.junit.Assert.*;

public class ApplicationTest {

    final static TrafficLight trafficLight = new TrafficLight();

    @Test
    public void checkLightColor() {
        String[] minutes = {"4","3","2"};
        trafficLight.setRedLightMinutes(Integer.parseInt(minutes[0]));
        trafficLight.setYellowLightMinutes(Integer.parseInt(minutes[1]));
        trafficLight.setGreenLightMinutes(Integer.parseInt(minutes[2]));
        assertEquals(trafficLight.getRedLightMinutes(),4);
        assertEquals(trafficLight.getYellowLightMinutes(),3);
        assertEquals(trafficLight.getGreenLightMinutes(),2);
    }
}
