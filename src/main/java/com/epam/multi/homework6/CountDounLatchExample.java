package com.epam.multi.homework6;

import java.util.concurrent.CountDownLatch;

public class CountDounLatchExample {

  private static final CountDownLatch cdLatch = new CountDownLatch(10);

  public static void sayHello(int name) {
    try {
      Thread.sleep(1000*name);
      cdLatch.countDown();
      System.out.println(name + " is ready to say hello");
      cdLatch.await();
      System.out.println("Hello from " + name);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      new Thread(new NamedRunnableCDE(i)).start();
    }
  }
}
