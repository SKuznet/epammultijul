package com.epam.multi.homework1;

import com.epam.multi.homework1.light.GreenLight;
import com.epam.multi.homework1.light.RedLight;
import com.epam.multi.homework1.light.YellowLight;
import java.util.LinkedList;
import java.util.List;

public class TrafficLight {
  private List<Thread> list;

  public TrafficLight() {
    list = new LinkedList<>();
    list.add(new Thread(new RedLight()));
    list.add(new Thread(new YellowLight()));
    list.add(new Thread(new GreenLight()));
    for (Thread thread : list) {
      thread.setDaemon(true);
      thread.start();
    }
  }

  public void setlight(int munute) {
    switch (munute) {
      case (1):
      case (2):
        list.get(0).interrupt();
        break;
      case (3):
        list.get(1).interrupt();
        break;
      case (4):
      case (5):
        list.get(2).interrupt();
        break;
      default:
        System.out.println("NO LIGHT");
    }
  }
}
