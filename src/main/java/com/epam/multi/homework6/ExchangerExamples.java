package com.epam.multi.homework6;

import java.util.concurrent.Exchanger;

public class ExchangerExamples {

  private static final Exchanger<String> EXCHANGER = new Exchanger<>();

  public static void main(String[] args) {
    String firstPack = "Package 1";
    String secondPack = "Package 2";
    new Thread (new Postman("Firstman",firstPack,1000)).start();
    new Thread (new Postman("Secondman",secondPack,5000)).start();
  }

  public static class Postman implements Runnable {

    String name;
    String pack;
    int sleep;

    public Postman(String name, String pack, int sleep) {
      this.pack = pack;
      this.name = name;
      this.sleep = sleep;
    }

    @Override
    public void run() {
      try {
        System.out.println("My name is " + name + " and i have " + pack);
        System.out.println("I will sleep for " + sleep);
        Thread.sleep(sleep);
        System.out.println("My name is " + name + " and i am awake and want to exchange");
        pack=EXCHANGER.exchange(pack);
        System.out.println("My name is " + name + " and now i have " + pack);
        Thread.sleep(sleep);
        name=EXCHANGER.exchange(name);
        System.out.println("Wait I have "+pack+" that means I am "+name+" now!");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }
  }
}

