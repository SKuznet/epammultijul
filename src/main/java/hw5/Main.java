package hw5;

public class Main {

    public static void main(String[] args) {
        int horsesNum = 7;
        int pause = 200;

        Player player = new Player(5000);
        Player player1 = new Player(5000);

        Bookmaker bookmaker = new Bookmaker();

        bookmaker.acceptBet(player, 1);
        bookmaker.acceptBet(player1, 2);

        new HorseRace(horsesNum, pause, bookmaker);


    }

}
