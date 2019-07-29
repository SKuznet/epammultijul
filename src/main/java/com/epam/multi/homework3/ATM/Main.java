package com.epam.multi.homework3.ATM;

public class Main {
  public static void main(String[] args) {
    ATM atm = new ATM();
    atm.run();
    atm.insertCard();
    atm.insertPin(1234);
  }
}
