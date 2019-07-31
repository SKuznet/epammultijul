package com.epam.multi.homework1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TrafficLightTest {

    private List<String> light = new ArrayList<>();

    private TrafficLight tLight1 = new TrafficLight();
    private TrafficLight tLight2 = new TrafficLight(20);

    {
        light.add("Red");
        light.add("Yellow");
        light.add("Green");
    }

    @Test
    public void currentLight() {
        tLight1.setCurrentTime(20);
        tLight2.setCurrentTime(20);

        assertEquals(tLight1.currentLight(), tLight2.currentLight());

        tLight2.setCurrentTime(1);

        assertNotEquals(tLight1.currentLight(), tLight2.currentLight());
    }

}
