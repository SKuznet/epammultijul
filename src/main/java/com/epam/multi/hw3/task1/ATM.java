package com.epam.multi.hw3.task1;

public class ATM {
    private static int cashAmount = 100;
    private static ATM atmInstance;

    private ATM() {
    }

    public static ATM getAtmInstance() {
        if (atmInstance == null) {
            atmInstance = new ATM();
        }
        return atmInstance;
    }

    public static void getCash(int cash) {
        if (cash > cashAmount) {

        } else {
            System.err.println("No way");
        }
    }

    public static String getCashAmount() {
        return cashAmount + "$";
    }

    public static void setCashAmount(int cashAmount) {
        ATM.cashAmount += cashAmount;
    }
}
