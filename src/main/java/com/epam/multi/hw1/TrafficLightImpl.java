package com.epam.multi.hw1;

import static com.epam.multi.hw1.TrafficSignal.*;

public class TrafficLightImpl implements TrafficLight{

    @Override
    public TrafficSignal getTrafficSignal(int currentTime) {
        int numberOfFullCycles = currentTime / FULL_CYCLE;
        int currentCycleTime = currentTime - (numberOfFullCycles * FULL_CYCLE);

        if (currentCycleTime < RED.getTime()) {
            return RED;
        } else if (currentCycleTime < YELLOW.getTime()){
            return YELLOW;
        } else {
            return GREEN;
        }
    }
}
