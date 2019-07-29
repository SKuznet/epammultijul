package com.epam.multi.homework3.ATM;

public class NoCash implements ATMState {

  ATM ATM;

  public NoCash(ATM ATM) {
    this.ATM = ATM;
  }

  public void insertCard() {
    System.out.println("We don't have any money");
    System.out.println("Your card is ejected");
  }

  public void ejectCard() {
    System.out.println("We don't have any money");
    System.out.println("There is no card to eject");
  }

  public void requestCash(int cashToWithdraw) {
    System.out.println("We don't have any money");
  }

  public void insertPin(int pinEntered) {
    System.out.println("We don't have any money");
  }
}
