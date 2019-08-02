package hw6;

public class Customer {
    private double money;
    private String name;
    private Bet bet;

    public Customer() {
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void makeBet(double money, int horseNumber) {
        bet = new Bet(money, horseNumber);
    }

    public Bet getBet() {
        Bet bet = new Bet(this.bet.getMoney(), this.bet.getHorseNumber());
        return bet;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "total money=" + money +
                ", name='" + name + '\'' +
                ", bet money=" + bet.getMoney() +
                ", horse=" + bet.getHorseNumber() +
                '}';
    }
}
