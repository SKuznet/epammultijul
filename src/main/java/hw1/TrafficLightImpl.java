package hw1;

import static hw1.TrafficLightColor.*;

import java.util.function.Predicate;

public class TrafficLightImpl implements TrafficLight {
  @Override
  public TrafficLightColor getCurrentColor(int minute) {
    Predicate<Integer> checkDuration = b -> minute % TOTAL_DURATION < b;

    if (checkDuration.test(RED.getDuration())) {
      return RED;
    }
    else if (checkDuration.test(RED.getDuration() + YELLOW.getDuration())) {
      return YELLOW;
    }
    return GREEN;
  }
}
