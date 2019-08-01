package com.epam.multi.hw6;

import com.epam.multi.hw6.SemaphoreExample;

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

