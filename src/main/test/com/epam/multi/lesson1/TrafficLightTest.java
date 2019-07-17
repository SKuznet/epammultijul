package com.epam.multi.lesson1;

import com.epam.multi.lesson1.homework.LightColor;
import com.epam.multi.lesson1.homework.TrafficLight;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class TrafficLightTest {
    /**
     *
     */
    @Test
    void getLightColorsByTimePoints() {
        TrafficLight trafficLight = new TrafficLight();
        LightColor[] expected = trafficLight.getLightColorsByTimePoints(new int[]{1,10,7});
        LightColor[] actual = {LightColor.RED,LightColor.RED,LightColor.GREEN};

        assertArrayEquals(expected, actual);
    }
}
