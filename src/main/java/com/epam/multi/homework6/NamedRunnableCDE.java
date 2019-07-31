package com.epam.multi.homework6;

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
