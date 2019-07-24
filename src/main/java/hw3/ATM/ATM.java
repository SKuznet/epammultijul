package hw3.ATM;

public class ATM {
    public static final  ATM INSTANCE = new ATM();
    private static final Object key = new Object();

    public void getMoney(int amount) {
        synchronized (key) {
            int money = Account.INSTANCE.getMoneyAmount();
            if (amount <= money) {
                Account.INSTANCE.setMoneyAmount(money - amount);
                System.out.println("Money was successfully withdrawn");
            } else {
                System.err.println("Not enough money for withdrawal");
            }
            System.out.println("Current account money amount: " + Account.INSTANCE.getMoneyAmount());
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Customer("Alexey");
        Thread thread2 = new Customer("Alisa");
        Thread thread3 = new Customer("Andrei");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
