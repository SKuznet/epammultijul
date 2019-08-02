package com.epam.multi.homework7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Race {

  private static CountDownLatch waitAllHorses;
  private static List<Thread> horses = new ArrayList<>();
  private static List<Integer> results = Collections.synchronizedList(new ArrayList<>());

  Race() {
    waitAllHorses = new CountDownLatch(8);
    for (int i = 0; i < 8; i++) {
      horses.add(new Thread(new RunnableHorse(i + 1)));
      horses.get(i).start();
    }
  }

  public static void start(int stamina, int name) {
    try {
      waitAllHorses.countDown();
      waitAllHorses.await();
      System.out.println("GO!");
      Thread.sleep(stamina);
      Hippodrome.results.add(name);
    } catch (InterruptedException e) {
      System.out.println("кто-то вмешивается в гонку");
    }
  }
}
