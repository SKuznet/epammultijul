package com.epam.multi.lesson1.homework1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrafficLightTest {

    private TrafficLight trafficLight;
    /**
     * Before test actions*/
    @Before
    public void initTest(){
        trafficLight = new TrafficLight();
    }
    /**
     * After test actions*/
    @After
    public void afterTest(){
        trafficLight = null;
    }

    /**
     * Test checking light for number 1
     * It should be RED*/
    @Test
    public void checkLightRed1() {
        assertEquals(Lights.RED, trafficLight.checkLight(1));
    }
    /**
     * Test checking light for number 2
     * It should be RED*/
    @Test
    public void checkLightRed2() {
        assertEquals(Lights.RED, trafficLight.checkLight(2));
    }
    /**
     * Test checking light for number 3
     * It should be YELLOW*/
    @Test
    public void checkLightRed3() {
        assertEquals(Lights.YELLOW, trafficLight.checkLight(3));
    }
    /**
     * Test checking light for number 4
     * It should be YELLOW*/
    @Test
    public void checkLightRed4() {
        assertEquals(Lights.YELLOW, trafficLight.checkLight(4));

    }
    /**
     * Test checking light for number 5
     * It should be YELLOW*/
    @Test
    public void checkLightRed5() {
        assertEquals(Lights.YELLOW, trafficLight.checkLight(5));
    }
    /**
     * Test checking light for number 6
     * It should be GREEN*/
    @Test
    public void checkLightRed6() {
        assertEquals(Lights.GREEN, trafficLight.checkLight(6));
    }
    /**
     * Test checking light for number 7
     * It should be GREEN*/
    @Test
    public void checkLightRed7() {
        assertEquals(Lights.GREEN, trafficLight.checkLight(7));
    }
    /**
     * Test checking light for number 8
     * It should be GREEN*/
    @Test
    public void checkLightRed8() {
        assertEquals(Lights.GREEN, trafficLight.checkLight(8));
    }
    /**
     * Test checking light for number 9
     * It should be GREEN*/
    @Test
    public void checkLightRed9() {
        assertEquals(Lights.GREEN, trafficLight.checkLight(9));
    }
    /**
     * Test checking light for negative number
     * It should be WRONGINPUT*/
    @Test
    public void checkLightNegative() {
        assertEquals(Lights.WRONGINPUT, trafficLight.checkLight(-7));
    }
}
