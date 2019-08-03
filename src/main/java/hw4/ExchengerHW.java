package hw4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchengerHW {

    public static void main(String[] args) {
        Exchanger<Letter> exchanger = new Exchanger<>();
        new MakingLetter(exchanger);
        new SendingLetter(exchanger);
    }

}

class MakingLetter extends Thread {
    private Exchanger<Letter> exchanger;
    private Letter letter;

    public MakingLetter(Exchanger<Letter> exchanger) {
        this.exchanger = exchanger;
        this.start();
    }

    @Override
    public void run() {

        try {
            for (int i = 0; i < 3; i++) {
                letter = new Letter(Thread.currentThread().getName(), "to someone", i);
                exchanger.exchange(letter);
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

    }
}

class SendingLetter extends Thread {
    private Exchanger<Letter> exchanger;
    private List<Letter> letterList = new ArrayList<>();

    public SendingLetter(Exchanger<Letter> exchanger) {
        this.exchanger = exchanger;
        this.start();
    }

    @Override
    public void run() {
        try {
            while (letterList.size() < 3) {
                letterList.add(exchanger.exchange(new Letter(null, null, 0)));
            }
            System.out.println("All letters was made and ready to send");
            for (Letter letter : letterList) {
                System.err.println(letter);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class Letter {
    private String from;
    private String to;
    private int id;

    public Letter(String from, String to, int id) {
        this.from = from;
        this.to = to;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Letter{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", id=" + id +
                '}';
    }
}
