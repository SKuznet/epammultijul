package condition;

public class Customer implements Runnable{
    private Store store;

    public Customer(Store store){
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            store.get();
        }
    }
}