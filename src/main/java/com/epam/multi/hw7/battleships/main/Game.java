package com.epam.multi.hw7.battleships.main;

import com.epam.battleships.player.Player;
import com.epam.battleships.state.GameState;

/**
 * Main game class that contains game loop and both players.
 * Also contains references to both players and contains current GameState
 */
public class Game {
    Player playerOne;
    Player playerTwo;
    GameState state = GameState.PLAYER1_IS_PLACING_SHIPS;
    private boolean gameFinished = false;

    public Game(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    /**
     * Game loop, contains switch which determines what to do in every GameState
     */
    public void run() {
        while (!gameFinished) {
            switch (state) {
                case PLAYER1_IS_PLACING_SHIPS:
                    playerTwo.draw(playerOne);
                    System.out.println("Player 2 is placing ships");
                    state = playerTwo.placeShipsAndGetNewState(state);
                    break;
                case PLAYER2_IS_PLACING_SHIPS:
                    playerOne.draw(playerTwo);
                    System.out.println("Player 1 is placing ships");
                    state = playerOne.placeShipsAndGetNewState(state);
                    break;
                case PLAYER2_IS_ATTACKING:
                    playerOne.draw(playerTwo);
                    System.out.println("Player 1 is attacking");
                    state = playerOne.shootAndGetNewState(state, playerTwo);
                    checkWinCondition();
                    break;
                case PLAYER1_IS_ATTACKING:
                    playerTwo.draw(playerOne);
                    System.out.println("Player 2 is attacking");
                    state = playerTwo.shootAndGetNewState(state, playerOne);
                    checkWinCondition();
                    break;
            }
        }
    }

    /**
     * Method determines how many ships each player has killed compare to enemy fleet size, and
     * displays winner player and ends the game.
     */
    private void checkWinCondition() {
        if (playerOne.getShipsSize() == playerTwo.getDeadEnemyShipsSize()) {
            System.out.println("Player 2 WIN!");
            gameFinished = true;
        } else if (playerTwo.getShipsSize() == playerOne.getDeadEnemyShipsSize()) {
            System.out.println("Player 1 WIN!");
            gameFinished = true;
        }
    }
}
