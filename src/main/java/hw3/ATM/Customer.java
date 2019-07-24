package hw3.ATM;

public class Customer extends Thread {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.err.println(this.name);
        ATM.INSTANCE.getMoney(50);
    }
}
