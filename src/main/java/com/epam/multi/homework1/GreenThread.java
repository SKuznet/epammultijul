package com.epam.multi.homework1;

public class GreenThread implements Runnable {

  @Override
  public void run() {
    String color = "GREEN";
    try {
      Thread.sleep(10000000);
    } catch (InterruptedException e) {
      System.out.println(color + " LIGHT");
      run();
    }
  }
}
