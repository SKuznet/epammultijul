package com.epam.multi.homeworks.homework1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrafficLightTest {

    private TrafficLight trafficLight;


    @AfterEach
    void tearDown() {
        trafficLight = null;
    }

    @Test
    void runRed() {
        trafficLight = new TrafficLight(1);
        assertEquals(trafficLight.showColor(), "Красный");
    }

    @Test
    void runYellow() {
        trafficLight = new TrafficLight(4);
        assertEquals(trafficLight.showColor(), "Желтый");
    }

    @Test
    void runGreen() {
        trafficLight = new TrafficLight(9);
        assertEquals(trafficLight.showColor(), "Зеленый");
    }
}