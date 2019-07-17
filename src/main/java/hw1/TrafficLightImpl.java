package hw1;

import static hw1.TrafficLightColor.*;

import java.util.function.BiPredicate;

public class TrafficLightImpl implements TrafficLight {
  @Override
  public TrafficLightColor getCurrentColor(int minute) {
    BiPredicate<Integer, Integer> checkDuration = (a, b) -> minute % (a) < b;

    if (checkDuration.test(TOTAL_DURATION, RED.getDuration())) {
      return RED;
    }
    else if (checkDuration.test(TOTAL_DURATION, RED.getDuration() + YELLOW.getDuration())) {
      return YELLOW;
    }
    return GREEN;
  }
}
