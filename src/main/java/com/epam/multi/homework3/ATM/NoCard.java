package com.epam.multi.homework3.ATM;

public class NoCard implements ATMState {

  ATM ATM;

  public NoCard(ATM ATM) {
    this.ATM = ATM;
  }

  public void insertCard() {
    System.out.println("Please enter pin");
    ATM.setATMState(ATM.getYesCardState());
  }

  public void ejectCard() {
    System.out.println("No card entered");
  }

  public void requestCash(int cashToWithdraw) {
    System.out.println("No card entered");
  }

  public void insertPin(int pinEntered) {
    System.out.println("No card entered");
  }
}
