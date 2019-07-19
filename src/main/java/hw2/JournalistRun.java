package hw2;

public class JournalistRun implements Runnable {
    private int id;

    JournalistRun(int id) {
        this.id = id;
    }

    public void run() {
        for (int j = 0; j < 6; j++) {
            System.out.println("Inside : " + Thread.currentThread().getName() + " with id " + id);
            switch (j) {
                case 0:
                    System.out.println("let me in");
                    break;
                case 1:
                    System.out.println("let me in!");
                    break;
                case 2:
                    System.out.println("Let me in!");
                    break;
                case 3:
                    System.out.println("Let me IN!");
                    break;
                case 4:
                    System.out.println("LET ME IN!");
                    break;
                case 5:
                    System.out.println("LET ME IN!!!!!!");
                    break;
            }
        }
    }
}
