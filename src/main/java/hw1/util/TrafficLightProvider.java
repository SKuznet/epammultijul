package main.java.hw1.util;

import java.util.List;
import main.java.hw1.TrafficLight;

public class TrafficLightProvider {
    List<TrafficLight> trafficLights;

    public void addTrafficLight(TrafficLight tl){
        trafficLights.add(tl);
    }
}
