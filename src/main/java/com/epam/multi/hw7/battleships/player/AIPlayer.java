package com.epam.multi.hw7.battleships.player;


import com.epam.battleships.ship.Coordinate;
import com.epam.battleships.ship.Ship;
import com.epam.battleships.ship.ShipType;
import com.epam.battleships.state.GameState;

/**
 * Class describes how AI player can shoot and place ships
 */
public class AIPlayer extends Player {
    public AIPlayer(Grid ownGrid, Grid enemyGrid) {
        super(ownGrid, enemyGrid);
    }

    /**
     * Method places ships and return next state
     *
     * @param state current state
     * @return      next state
     */
    @Override
    public GameState placeShipsAndGetNewState(GameState state) {
        placeShips();
        return state.getNextState();
    }

    /**
     * Method shoots at enemy ships and return next state
     * @param state         current state
     * @param anotherPlayer attacked player
     * @return
     */
    @Override
    public GameState shootAndGetNewState(GameState state, Player anotherPlayer) {
        if (!shoot(anotherPlayer)) {
            return state.getNextState();
        } else {
            return state;
        }
    }

    /**
     * Draw human player grid if we want to draw grid for AI player.
     *
     * @param anotherPlayer enemy player
     */
    @Override
    public void draw(Player anotherPlayer) {
        anotherPlayer.draw(this);
    }

    /**
     * Automatically generates ships that are correctly placed on grid.
     * Generate random ship placement until all ships are correctly placed
     */
    public void placeShips() {
        for (ShipType currentShipType : ShipType.values()) {
            for (int currentShipIdx = 0; currentShipIdx < currentShipType.getNumberShips(); ++currentShipIdx) {
                while (true) {
                    Coordinate coordinate = Coordinate.nextRandomCoordinate();
                    Ship shipParallelY = new Ship(coordinate,
                            coordinate.plusY(currentShipType.getShipLength()),
                            currentShipType);
                    boolean isPlacedY = isCorrectlyPlaced(shipParallelY);
                    if (isPlacedY) {
                        shipParallelY.placeShip();
                        ships.add(shipParallelY);
                        break;
                    }
                    Ship shipParallelX = new Ship(coordinate,
                            coordinate.plusX(currentShipType.getShipLength()),
                            currentShipType);
                    boolean isPlacedX = isCorrectlyPlaced(shipParallelX);
                    if (isPlacedX) {
                        shipParallelX.placeShip();
                        ships.add(shipParallelX);
                        break;
                    }
                }
            }
        }
    }


    /**
     * Choose random position where to shoot.
     * Chosen position shouldn't be chosen previously.
     *
     * @param anotherPlayer enemy player
     * @return              true if hit enemy ship, else false
     */
    public boolean shoot(Player anotherPlayer) {
        Coordinate shootAt = Coordinate.nextRandomCoordinate();
        while (isAlreadyShootHere(shootAt)) {
            shootAt = Coordinate.nextRandomCoordinate();
        }
        return shootAtPosition(anotherPlayer, shootAt);
    }
}
