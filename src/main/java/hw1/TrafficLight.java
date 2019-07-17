package hw1;

public interface TrafficLight {

  /**
   * Method returns color of the traffic light at that minute.
   * @param minute int represents minute.
   * @return traffic light color
   */
  TrafficLightColor getCurrentColor(int minute);

}
