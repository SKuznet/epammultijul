package com.epam.multi.hw6;

import com.epam.multi.hw6.NamedRunnableSE;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

  private static final Semaphore SEMAPHORE = new Semaphore(2, true);

  public static void sayHello(int name) {
    try {
      System.out.println(name + " is trying to say hello");
      SEMAPHORE.acquire();
      System.out.println("Hello from " + name);
      Thread.sleep(1000);
      SEMAPHORE.release();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Thread[] threads = new Thread[10];
    for (int i = 0; i < 10; i++) {
      new Thread(new NamedRunnableSE(i)).start();
    }
  }
}
