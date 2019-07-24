package com.epam.multi.lesson4.hw.task1;

public class User {
    private String name;

    public void getMoney(ATM atm, int amount){
        if(atm.giveMoney(amount)){
            System.out.println(name + ": Yeah! I can eat something today!");
        }
    }

    public User(String name) {
        this.name = name;
    }
}
