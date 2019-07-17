package hw1;

public enum TrafficLightColor {
  RED(2),
  YELLOW(3),
  GREEN(4);

  public static int TOTAL_DURATION = RED.duration + YELLOW.duration + GREEN.duration;
  private int duration;

  TrafficLightColor(int duration) {
    this.duration = duration;
  }

  public int getDuration() {
    return duration;
  }
}
