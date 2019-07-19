package com.epam.multi.homework1;

public class Main {
  public static void main(String[] args) {
    int[] minutes = {1, 2, 3, 4, 5,6,7,8,9};
    TrafficLight tl = new TrafficLight();
    for (int minute : minutes) {
      try {
        {
          Thread.sleep(1000);
          tl.setlight(minute);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
