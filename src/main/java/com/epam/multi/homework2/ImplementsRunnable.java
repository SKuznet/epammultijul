package com.epam.multi.homework2;

public class ImplementsRunnable implements Runnable {
  int priority;

  public ImplementsRunnable(int priority) {
    this.priority = priority;
  }

  @Override
  public void run() {
   Main.printPriority(priority);
  }
}
