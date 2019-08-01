package condition;

public class ConditionExercise {

    public static void main(String[] args) {
        Store store = new Store();
        Factory factory = new Factory(store);
        Customer customer = new Customer(store);
        new Thread(factory).start();
        new Thread(customer).start();
    }
}
