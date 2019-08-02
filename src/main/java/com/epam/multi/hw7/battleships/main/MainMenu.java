package com.epam.multi.hw7.battleships.main;

import com.epam.battleships.inputcontroller.Action;
import com.epam.battleships.inputcontroller.InputController;
import com.epam.battleships.player.AIPlayer;
import com.epam.battleships.player.Grid;
import com.epam.battleships.player.HumanPlayer;
import com.epam.battleships.player.Player;
import com.epam.battleships.ship.ShipType;
import com.epam.battleships.state.MenuState;

/**
 * Class determines behavior of main menu.
 * Depending on user input, class change menu state and create and start Game class with chosen type of Player.
 */
public class MainMenu {
    MenuState state = MenuState.VS_HUMAN;
    InputController inputController = new InputController();
    Game game;
    Grid player1OwnGrid = new Grid();
    Grid player1EnemyGrid = new Grid();
    Grid player2OwnGrid = new Grid();
    Grid player2EnemyGrid = new Grid();
    boolean exit = false;

    /**
     * Print current main menu state to console.
     */
    public void draw() {
        System.out.println("************************************");
        System.out.println();
        for (MenuState value : MenuState.values()) {
            if (value == state) {
                System.out.println("[*]  " + value.toString());
            } else {
                System.out.println("[ ]  " + value.toString());
            }
        }
        System.out.println();
        System.out.println("************************************");
    }

    /**
     * Method takes action and depending on it:
     * - changes current menu item,
     * - shows help
     * - quits
     * - creates and starts game with chosen player types
     * @param action action from input Controller
     */
    public void changeState(Action action) {
        switch (action) {
            case DOWN:
                state = state.getNextState();
                break;
            case UP:
                state = state.getPreviousState();
                break;
            case DO_ACTION:
                switch (state) {
                    case VS_HUMAN: {
                        Player player1 = new HumanPlayer(player1OwnGrid, player1EnemyGrid);
                        Player player2 = new HumanPlayer(player2OwnGrid, player2EnemyGrid);
                        Game game = new Game(player1, player2);
                        game.run();
                        break;
                    }
                    case VS_AI: {
                        Player player1 = new HumanPlayer(player1OwnGrid, player1EnemyGrid);
                        Player player2 = new AIPlayer(player2OwnGrid, player2EnemyGrid);
                        game = new Game(player1, player2);
                        game.run();
                        break;
                    }
                    case HELP:
                        drawHelp();
                        break;
                    case EXIT:
                        exit = true;
                        break;
                }
        }
    }

    /**
     * Method print help about input settings and about types of ships
     */
    private void drawHelp() {
        System.out.println("Use 'w','a','s','d' to move ship or aim up, left, down, right respectively");
        System.out.println("Use 'q' to rotate ship and 'e' to place ship or to shoot at chosen position");
        System.out.println("Type exit if you want to quit");
        System.out.println("There is 4 types of Ships: ");
        for (ShipType value : ShipType.values()) {
            System.out.println(value.name() + " having " + value.getNumberShips()
                    + " number of ships with length " + (value.getShipLength() + 1));
        }

    }

    /**
     * Main loop of main menu
     */
    public void run() {
        while (!exit) {
            draw();
            inputController.nextAction();
            changeState(inputController.getCurrentAction());
        }
    }
}
