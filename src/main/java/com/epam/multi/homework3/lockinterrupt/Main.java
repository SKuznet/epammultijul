package com.epam.multi.homework3.lockinterrupt;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
  public static void main(String[] args) {
    ReentrantLock lock= new ReentrantLock();
    Thread[] threads= new Thread[10];

    for (int i = 0; i < 10; i++) {
      threads[i]=new Thread(new InterThread(i,lock,i));
      threads[i].start();
    }

    for (int i = 0; i < 10; i++) {
      threads[i].interrupt();
    }
  }
}
