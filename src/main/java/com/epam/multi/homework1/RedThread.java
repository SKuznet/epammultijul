package com.epam.multi.homework1;

public class RedThread implements Runnable {
  @Override
  public void run() {
    String color = "RED";
    try {
      Thread.sleep(10000000);
    } catch (InterruptedException e) {
      System.out.println(color + " LIGHT");
      run();
    }
  }
}
