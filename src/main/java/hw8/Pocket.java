package main.java.hw8;

public enum  Pocket {
    INSTANCE;

    private int amount = 1000;

    public int getAmount(){
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
