package com.epam.multi.hw7.battleships.player;

import com.epam.battleships.ship.Coordinate;
import com.epam.battleships.ship.Ship;
import com.epam.battleships.ship.Shoot;
import com.epam.battleships.state.GameState;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Basic class for AIPlayer and HumanPlayer
 * Every Player has ships - list of ships, shoots on enemy field(grid) and set of dead enemy ships
 * Class got plenty util methods which helps to determines right position for ship:
 * isOverlapOtherShips and isCorrectlyPlaced.
 * abstract methods define to basic functionalities for players: shot and change state, place ships and change state
 */
public abstract class Player {
    protected List<Ship> ships = new ArrayList<>();
    protected Grid ownGrid;
    protected Grid enemyGrid;
    protected ArrayList<Shoot> shoots = new ArrayList<>();
    protected Set<Ship> deadEnemyShips = new HashSet<>();

    public Player(Grid ownGrid, Grid enemyGrid) {
        this.ownGrid = ownGrid;
        this.enemyGrid = enemyGrid;
    }

    public int getShipsSize() {
        return ships.size();
    }
    public int getDeadEnemyShipsSize() {
        return deadEnemyShips.size();
    }

    /**
     * Method check whether ship is on field and do not overlap other ships of current player.
     *
     * @param currentShip ship for which we are checking correctness of placement
     * @return            is ship correctly placed
     */
    protected boolean isCorrectlyPlaced(Ship currentShip) {
        if (Grid.isOutOfBounds(currentShip.getStartCoordinate())
                || Grid.isOutOfBounds(currentShip.getEndCoordinate())) {
            return false;
        } else if (isOverlapOtherShips(currentShip)) {
            return false;
        }
        return true;
    }

    /**
     * Method check whether ship do not overlap other ships of current player.
     *
     * @param ship ship for which we are checking correctness of placement
     * @return     is ship correctly placed
     */
    protected boolean isOverlapOtherShips(Ship ship) {
        for (Ship currentShip : ships) {
            if (!currentShip.isPlaced()) {
                continue;
            }
            if (currentShip.isOverlap(ship)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method check if chosen shoot hit at least one of player ships.
     * Decrease number of lives for hit ship.
     *
     * @param shoot chosen shoot
     * @return      if hit ships
     */
    public boolean hitShips(Coordinate shoot) {
        for (Ship ship : ships) {
            if (ship.isHit(shoot)) {
                ship.decreaseLives();
                return true;
            }
        }
        return false;
    }

    /**
     * Shoot at position of another player where coordinate is shoot.
     * Add shoot to list of shoots of current player.
     * Add dead enemy ship to set if find any
     *
     * @param anotherPlayer attacked player
     * @param shoot         chosen shoot
     * @return              true, if shoot hit any ship
     */
    public boolean shootAtPosition(Player anotherPlayer, Coordinate shoot) {
        if (anotherPlayer.hitShips(shoot)) {
            shoots.add(new Shoot(shoot.x, shoot.y, true));
            deadEnemyShips.addAll(
                    anotherPlayer.ships
                            .stream()
                            .filter(s -> s.getNumberOfLives() == 0)
                            .collect(Collectors.toSet())
            );
            return true;
        } else {
            shoots.add(new Shoot(shoot.x, shoot.y, false));
            return false;
        }
    }

    /**
     * Method check if already shoot here.
     * Method find specified shoot in list of shoot for current player
     * @param shootPointer place to shoot
     * @return             is already shoot here
     */
    protected boolean isAlreadyShootHere(Coordinate shootPointer) {
        for (Shoot shoot : shoots) {
            if (shoot.x == shootPointer.x && shoot.y == shootPointer.y) {
                return true;
            }
        }
        return false;
    }

    /**
     * Abstract method, should describe how to place ships.
     *
     * @param state current state
     * @return      new state
     */
    public abstract GameState placeShipsAndGetNewState(GameState state);

    /**
     * Abstract method, should describe how to shoot another player.
     *
     * @param state         current state
     * @param anotherPlayer attacked player
     * @return              new state
     */
    public abstract GameState shootAndGetNewState(GameState state, Player anotherPlayer);

    /**
     * Abstract method, should describe how to draw enemy grid and own grid
     *
     * @param anotherPlayer enemy player
     */
    public abstract void draw(Player anotherPlayer);
}
