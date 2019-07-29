package com.epam.multi.homework3.ATM;

public interface ATMState {

  void insertCard();

  void ejectCard();

  void insertPin(int pinEntered);

  void requestCash(int cashToWithdraw);
}
