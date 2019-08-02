package com.epam.multi.hw7.battleships.player;

import com.epam.battleships.inputcontroller.Action;
import com.epam.battleships.inputcontroller.InputController;
import com.epam.battleships.ship.Coordinate;
import com.epam.battleships.ship.Ship;
import com.epam.battleships.ship.ShipType;
import com.epam.battleships.state.GameState;

import java.util.Optional;

/**
 * Class describes how human player can shoot and place ships
 */
public class HumanPlayer extends Player {

    InputController inputController = new InputController();
    public HumanPlayer(Grid ownGrid, Grid enemyGrid) {
        super(ownGrid, enemyGrid);
        for (ShipType currentShipType : ShipType.values()) {
            for (int i = 0; i < currentShipType.getNumberShips(); ++i) {
                ships.add(new Ship(
                        new Coordinate(
                                Grid.getRowAndColumnNumber() / 3,
                                Grid.getRowAndColumnNumber() / 3),
                        new Coordinate(
                                Grid.getRowAndColumnNumber() / 3 + currentShipType.getShipLength(),
                                Grid.getRowAndColumnNumber() / 3),
                        currentShipType));
            }
        }
    }

    /**
     * In method user get input action and try to place ships depending on this action, using method placeShips.
     * If human place all ships, method returns next state.
     *
     * @param state current state
     * @return      new state
     */
    @Override
    public GameState placeShipsAndGetNewState(GameState state) {
        inputController.nextAction();
        if (!placeShips(inputController.getCurrentAction())) {
            return state.getNextState();
        } else {
            return state;
        }

    }

    /**
     * In method user get input action and try to shoot enemy ships depending on this action, using method shoot.
     * If human miss, method returns next state.
     *
     * @param state         current state
     * @param anotherPlayer attacked player
     * @return              next state
     */
    @Override
    public GameState shootAndGetNewState(GameState state, Player anotherPlayer) {
        inputController.nextAction();
        if (!shoot(inputController.getCurrentAction(), anotherPlayer)) {
            return state.getNextState();
        } else {
            return state;
        }
    }

    /**
     * Method print grids to console
     *
     * @param anotherPlayer enemy player
     */
    @Override
    public void draw(Player anotherPlayer) {
        enemyGrid.draw(deadEnemyShips, shoots);
        ownGrid.draw(ships, anotherPlayer.shoots);
    }

    /**
     * Method that moves ships around grid or spin ship depending on input action.
     *
     * @param currentAction input current action from user
     * @return              true if not all ships are placed
     */
    public boolean placeShips(Action currentAction) {
        Optional<Ship> ship = ships.stream().filter(currShip -> !currShip.isPlaced()).findFirst();
        if (!ship.isPresent()) {
            return false;
        } else {
            Ship currentShip = ship.get();
            switch (currentAction) {
                case RIGHT:
                    currentShip.shiftY(1);
                    break;
                case LEFT:
                    currentShip.shiftY(-1);
                    break;
                case UP:
                    currentShip.shiftX(-1);
                    break;
                case DOWN:
                    currentShip.shiftX(1);
                    break;
                case SPIN_SHIP:
                    currentShip.spin();
                    break;
                case DO_ACTION:
                    if (isCorrectlyPlaced(currentShip)) {
                        currentShip.placeShip();
                    } else {
                        System.out.println("Wrong ship position");
                    }
                    break;
                case EXIT:
                    System.exit(0);
            }
            Optional<Ship> requiredShip = ships.stream().filter(currShip -> !currShip.isPlaced()).findFirst();
            if (requiredShip.isPresent()) {
                return true;
            } else {
                return false;
            }

        }
    }

    /**
     * Method moves shoot pointer around the grid depending on input action.
     * Also shoots at chosen position with method shootAtPosition()
     * @param currentAction input current action from user
     * @param anotherPlayer enemy player
     * @return              true, if shoot hit any ship
     */
    public boolean shoot(Action currentAction, Player anotherPlayer) {
        switch (currentAction) {
            case RIGHT:
                enemyGrid.shootPointer = enemyGrid.shootPointer.plusY(1);
                break;
            case LEFT:
                enemyGrid.shootPointer = enemyGrid.shootPointer.plusY(-1);
                break;
            case UP:
                enemyGrid.shootPointer = enemyGrid.shootPointer.plusX(-1);
                break;
            case DOWN:
                enemyGrid.shootPointer = enemyGrid.shootPointer.plusX(1);
                break;
            case DO_ACTION:
                if (!Grid.isOutOfBounds(enemyGrid.shootPointer) && !isAlreadyShootHere(enemyGrid.shootPointer)) {
                    return shootAtPosition(anotherPlayer, enemyGrid.shootPointer);
                } else {
                    System.out.println("Wrong shoot position");
                }
                break;
        }
        return true;
    }

}