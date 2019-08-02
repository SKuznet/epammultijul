package com.epam.multi.homework7;


import java.util.Random;

public class RunnableHorse implements Runnable {

  int name;
  int stamina;
  Random random= new Random();

  RunnableHorse(int name) {
    this.name = name;
    this.stamina = random.nextInt(500)+200;
  }

  @Override
  public void run() {
    Race.start(stamina,name);
  }
}
