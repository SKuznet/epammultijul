package com.epam.multi.homework1;

import java.util.LinkedList;
import java.util.List;

public class TrafficLight {
  private List<Thread> list;

  public TrafficLight() {
    list = new LinkedList<>();
    list.add(new Thread(new RedThread()));
    list.add(new Thread(new YellowThread()));
    list.add(new Thread(new GreenThread()));
    for (Thread thread : list) {
      thread.setDaemon(true);
      thread.start();
    }
  }

  public void setlight(int munute) {
    switch (munute) {
      case (3):
        list.get(1).interrupt();
        break;
      case (4):
      case (5):
        list.get(2).interrupt();
        break;
      default:
        list.get(0).interrupt();
    }
  }
}
