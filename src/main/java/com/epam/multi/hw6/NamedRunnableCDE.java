package com.epam.multi.hw6;

import com.epam.multi.hw6.CountDounLatchExample;

public class NamedRunnableCDE implements Runnable {

  int name;
  public NamedRunnableCDE(int name) {
    this.name = name;
  }

  @Override
  public void run() {
    CountDounLatchExample.sayHello(name);
  }
}
