package com.epam.multi.homework4.atomic;

public class AtomicIncrement implements Runnable {
  int number;

  public AtomicIncrement(int number) {
    this.number=number;
  }

  @Override
  public void run() {
    for (int i = 0; i < 50; i++) {
      System.out.println(Main.ai.addAndGet(number));
    }
  }
}
