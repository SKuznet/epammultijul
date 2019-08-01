package condition;

public class Factory implements Runnable{
    private Store store;

    public Factory(Store store){
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i<50; i++){
            store.put();
        }
    }
}
