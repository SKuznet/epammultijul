package com.epam.multi.homework1;

public abstract class Light implements Runnable {
  private String color;

  protected Light(String color) {
    this.color = color;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(10000000);
    } catch (InterruptedException e) {
      System.out.println(this.color + " LIGHT");
      run();
    }
  }
}
