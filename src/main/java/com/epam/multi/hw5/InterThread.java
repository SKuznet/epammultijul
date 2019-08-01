package com.epam.multi.hw5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class InterThread implements Runnable {
  private String name;
  private ReentrantLock lock;
  private boolean isInterrupt;

  public InterThread(int id, ReentrantLock lock, int i) {
    name = "My id is " + id;
    this.lock = lock;
    isInterrupt= i % 2 == 0;
  }

  @Override
  public void run() {
    try {
      if (isInterrupt){
        lock.lockInterruptibly();
      }else {
        lock.lock();
      }
    } catch (InterruptedException e) {
      System.err.println("Interrupted wait " +name);
    }

    System.out.println("Hello "+name);

    try {
        TimeUnit.MILLISECONDS.sleep(50000);
    } catch (InterruptedException e) {
      System.out.println("Sleep interrupted "+name);
    } finally {
      lock.unlock();
    System.out.println("unlocked by "+name);
    }
  }
}
