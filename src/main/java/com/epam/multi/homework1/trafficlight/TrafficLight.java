package com.epam.multi.homework1.trafficlight;

import com.epam.multi.homework1.trafficlight.light.GreenLight;
import com.epam.multi.homework1.trafficlight.light.RedLight;
import com.epam.multi.homework1.trafficlight.light.YellowLight;
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

  public void setlight(int minute) {
    minute %= 10;
    if (minute > 5) {
      list.get(2).interrupt();
    }
    if (minute > 2 & minute < 6) {
      list.get(1).interrupt();
    }
    if (minute < 3) list.get(0).interrupt();
  }
}
