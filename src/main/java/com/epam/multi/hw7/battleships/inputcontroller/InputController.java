package com.epam.multi.hw7.battleships.inputcontroller;

import java.util.Scanner;

/**
 * Class that transform user input to enum Action
 */
public class InputController {
    public Action currentAction;
    Scanner reader = new Scanner(System.in);

    public InputController() {
    }

    public Action getCurrentAction() {
        return currentAction;
    }

    /**
     * Get input from Scanner reader and return next action, corresponding to string entered by user.
     * @return next action
     */
    public Action nextAction() {
        String string = reader.next();
        switch (string) {
            case "a": {
                return currentAction = Action.LEFT;
            }
            case "d": {
                return currentAction = Action.RIGHT;
            }
            case "w": {
                return currentAction = Action.UP;
            }
            case "s": {
                return currentAction = Action.DOWN;
            }
            case "q": {
                return currentAction = Action.SPIN_SHIP;
            }
            case "e": {
                return currentAction = Action.DO_ACTION;
            }
            case "exit": {
                return currentAction = Action.EXIT;
            }
            default: {
                System.out.println("Wrong input: try again.");
                return currentAction = Action.NONE_ACTION;
            }
        }
    }
}

