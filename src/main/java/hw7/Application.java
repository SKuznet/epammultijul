package hw7;

public class Application {

    public static void main(String[] args) {
        Gambler gambler = new Gambler();
        Hippodrome hippodrome = new Hippodrome();
        System.out.println("Welcome to horse race!");
        gambler.status();
        while (true) {
            gambler.setWantToContinue();
            if (gambler.makeBet()) {
                gambler.result(hippodrome.startRace());
                gambler.status();
            }
        }
    }
}
