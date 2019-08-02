package com.epam.multi.homework7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hippodrome {

  String name;
  int money;
  int bet;
  int horseNumber;
  Race race;
  public static List<Integer> results = Collections.synchronizedList(new ArrayList<>());
  BufferedReader reader;

  public void start()  {
    System.out.println("Welcome to a Horse riding");
    try {
      reader = new BufferedReader(new InputStreamReader(System.in));
      if (name == null) {
        register();
      }
      while (money > 0) {
        makeBet();
        startRace();
        victory();
        takeMoneyAndQuit();
      }
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  private void startRace() {
    race = new Race();
  }

  private void takeMoneyAndQuit() throws IOException {
    System.out.println("Do you want to take money and quit");
    String line;
    System.out.print("Y/N : ");
    line = reader.readLine();
    if (line != null) {
      if (line == "Y"||line == "y") {
        System.exit(0);
      }
    }
  }

  private void victory() {
    while (results.size() < 8) {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    if (horseNumber == results.get(0)) {
      System.out.println("victory horse " +results.get(0));
      System.out.println("You win");
    } else {
      System.out.println("victory horse " +results.get(0));
      System.out.println("You lose");
    }
  }

  private void register() throws IOException {
    System.out.println("Please register");
    String line;
    System.out.print("Your name: ");
    line = reader.readLine();
    if (line != null) {
      name = line;
    }
    System.out.print("Your money: ");
    line = reader.readLine();
    if (line != null) {
      money = Integer.parseInt(line);
    }
  }

  private void makeBet() throws IOException {
    System.out.println("Please make a bet");
    String line;
    line = reader.readLine();
    if (line != null) {
      if (money - Integer.parseInt(line) > 0) {
        bet = Integer.parseInt(line);
      }
    } else {
      System.out.println("Not enough money");
      makeBet();
    }
    line = reader.readLine();
    if (line != null) {
      if (Integer.parseInt(line) > 0 && Integer.parseInt(line) < 8) {
        horseNumber = Integer.parseInt(line);
      } else {
        System.out.println("wrong number");
        makeBet();
      }
    }
  }
}
