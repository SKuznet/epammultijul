package com.epam.multi.homework3.ATM;

public class HasPin implements ATMState {

  ATM ATM;

  public HasPin(ATM ATM) {
    this.ATM = ATM;
  }

  public void insertCard() {
    System.out.println("You already entered a card");
  }

  public void ejectCard() {
    System.out.println("Your card is ejected");
    ATM.setATMState(ATM.getNoCardState());
  }

  public void requestCash(int cashToWithdraw) {
    if (cashToWithdraw > ATM.cashInMachine) {
      System.out.println("You don't have that much cash available");
      System.out.println("Your card is ejected");
      ATM.setATMState(ATM.getNoCardState());
    } else {
      System.out.println(cashToWithdraw + " is provided by the machine");
      ATM.setCashInMachine(ATM.cashInMachine - cashToWithdraw);
      System.out.println("Your card is ejected");
      ATM.setATMState(ATM.getNoCardState());
      if (ATM.cashInMachine <= 0) {
        ATM.setATMState(ATM.getNoCashState());
      }
    }
  }

  public void insertPin(int pinEntered) {
    System.out.println("You already entered a PIN");
  }
}
