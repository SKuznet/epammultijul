package main.java.hw5;

public class Main {
    public static void main(String[] args) {
        Market market = new Market();
        Deliver deliver = new Deliver(market);
        Customer customer = new Customer(market);
        new Thread(deliver).start();
        new Thread(customer).start();
    }
}
