package hw3.entities;

public class Consumer {

    private final String name;
    private final int amountToGetFromATM;

    public Consumer(String name, int amountToGetFromATM) {
        this.name = name;
        this.amountToGetFromATM = amountToGetFromATM;
    }

    public String getName() {
        return name;
    }

    public int getAmountToGetFromATM() {
        return amountToGetFromATM;
    }
}
