package hw2;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CastSpellCallable implements Callable {

    private int id;

    public CastSpellCallable(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        TimeUnit.MILLISECONDS.sleep(10);
        return "CastSpellCallable id is: " + id;
    }

}
