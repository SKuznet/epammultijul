package com.epam.multi.homework3.ATM;

public class HasCard implements ATMState {

  ATM ATM;

  public HasCard(ATM ATM) {
    this.ATM = ATM;
  }

  public void insertCard() {
    System.out.println("You can only insert one card at a time");
  }

  public void ejectCard() {
    System.out.println("Your card is ejected");
    ATM.setATMState(ATM.getNoCardState());
  }

  public void requestCash(int cashToWithdraw) {
    System.out.println("You have not entered your PIN");
  }

  public void insertPin(int pinEntered) {
    if (pinEntered == 1234) {
      System.out.println("You entered the correct PIN");
      ATM.correctPinEntered = true;
      ATM.setATMState(ATM.getHasPin());
    } else {
      System.out.println("You entered the wrong PIN");
      ATM.correctPinEntered = false;
      System.out.println("Your card is ejected");
      ATM.setATMState(ATM.getNoCardState());
    }
  }
}
