package com.epam.multi.lesson1.homework1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrafficLightTest {

    private TrafficLight trafficLight;

    @Before
    public void initTest(){
        trafficLight = new TrafficLight();
    }

    @After
    public void afterTest(){
        trafficLight = null;
    }
    @Test
    public void checkLightRed1() {
        assertEquals(Lights.RED, trafficLight.checkLight(1));

    }
    @Test
    public void checkLightRed2() {
        assertEquals(Lights.RED, trafficLight.checkLight(2));

    }
    @Test
    public void checkLightRed3() {
        assertEquals(Lights.YELLOW, trafficLight.checkLight(3));

    }
    @Test
    public void checkLightRed4() {
        assertEquals(Lights.YELLOW, trafficLight.checkLight(4));

    }
    @Test
    public void checkLightRed5() {
        assertEquals(Lights.YELLOW, trafficLight.checkLight(5));

    }
    @Test
    public void checkLightRed6() {
        assertEquals(Lights.GREEN, trafficLight.checkLight(6));

    }
    @Test
    public void checkLightRed7() {
        assertEquals(Lights.GREEN, trafficLight.checkLight(7));

    }
    @Test
    public void checkLightRed8() {
        assertEquals(Lights.GREEN, trafficLight.checkLight(8));

    }

    @Test
    public void checkLightRed9() {
        assertEquals(Lights.GREEN, trafficLight.checkLight(9));

    }

    @Test
    public void checkLightNegative() {
        assertEquals(Lights.TRAFFICLIGHTISBROKEN, trafficLight.checkLight(-7));

    }
}
