package com.epam.multi.lesson4.homework.ATM;

public class ATMUser implements Runnable {
    private String name;

    public ATMUser(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ATMUser{" +
                "name='" + name + '\'' +
                '}';
    }

    public void getMoney(double money){
        System.out.println(toString() + "try to get " + money + " dollars");
        ATM.INSTANCE.getMoney(money);
    }

    @Override
    public void run() {
        getMoney(50);
    }
}
