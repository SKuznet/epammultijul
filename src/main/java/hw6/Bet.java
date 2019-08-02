package hw6;

public class Bet {
    private double money;
    private int horseNumber;

    public Bet(double money, int horseNumber) {
        this.money = money;
        this.horseNumber = horseNumber;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getHorseNumber() {
        return horseNumber;
    }

    public void setHorseNumber(int horseNumber) {
        this.horseNumber = horseNumber;
    }
}
