package com.epam.multi.homework2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
  public static void main(String[] args) {

    startRunnablePriority();
    getMessageFromCallable();
  }

  private static void getMessageFromCallable() {

    FutureTask future = new FutureTask(new ImplementsCallable());
    new Thread(future).start();
    try {
      System.out.println(future.get());
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }

  private static void startRunnablePriority() {
    List<Thread> list = new ArrayList<>();
    list.add(new Thread(new ImplementsRunnable(Thread.MIN_PRIORITY)));
    list.add(new Thread(new ImplementsRunnable(Thread.MIN_PRIORITY)));
    list.add(new Thread(new ImplementsRunnable(Thread.NORM_PRIORITY)));
    list.add(new Thread(new ImplementsRunnable(Thread.NORM_PRIORITY)));
    list.add(new Thread(new ImplementsRunnable(Thread.MAX_PRIORITY)));
    list.add(new Thread(new ImplementsRunnable(Thread.MAX_PRIORITY)));

    for (Thread t : list) {
      t.start();
    }
  }

  static synchronized void printPriority(int priority) {
    for (int i = 0; i < 2; i++) {
      System.out.println("My priority = " + priority);
    }
  }
}
