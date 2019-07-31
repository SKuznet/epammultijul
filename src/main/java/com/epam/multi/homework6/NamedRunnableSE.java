package com.epam.multi.homework6;

public class NamedRunnableSE implements Runnable {

  int name;
  public NamedRunnableSE(int name) {
    this.name = name;
  }

  @Override
  public void run() {
    SemaphoreExample.sayHello(name);
  }
}

