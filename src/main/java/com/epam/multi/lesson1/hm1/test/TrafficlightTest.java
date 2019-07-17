package com.epam.multi.lesson1.hm1.test;

import com.epam.multi.lesson1.hm1.java.Trafficlight;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TrafficlightTest {

    private List<Trafficlight> trafficlighList;

    @Before
    public void init() {
        trafficlighList.add(new Trafficlight());
    }

    @Test
    public void firstTest() {
        /*assertEquals();
        TRAFFICLIGHT.beautifulOutput();*/
        assertEquals(4, 2+2);
    }
}
