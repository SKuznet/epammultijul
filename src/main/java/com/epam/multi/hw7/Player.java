package com.epam.multi.hw7;

public class Player {

    private Long id;
    private String name;
    private int money;

    public Player(Long id, String name, int money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void addMoney(int sum){
        this.money += sum;
    }
}
