package com.epam.multi.hw7.battleships.ship;

import java.util.Iterator;
import java.util.Objects;

/**
 * Class represents ship, contains ship coordinates, flag is ship placed,
 * number of lives and ship type.
 */
public class Ship {
    ShipCoordinates shipCoordinates;
    private boolean isPlaced = false;
    private int numberOfLives;
    private ShipType type;

    public Ship(Coordinate startCoordinates, Coordinate endCoordinate, ShipType type) {
        numberOfLives = type.getShipLength() + 1;
        this.shipCoordinates = new ShipCoordinates(startCoordinates, endCoordinate);
        this.type = type;
    }

    public ShipCoordinates getShipCoordinates() {
        return shipCoordinates;
    }

    public boolean isPlaced() {
        return isPlaced;
    }

    public int getNumberOfLives() {
        return numberOfLives;
    }

    public ShipType getType() {
        return type;
    }

    public void decreaseLives() {
        numberOfLives--;
    }

    public void placeShip() {
        isPlaced = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return isPlaced == ship.isPlaced &&
                numberOfLives == ship.numberOfLives &&
                shipCoordinates.equals(ship.shipCoordinates) &&
                type == ship.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shipCoordinates, isPlaced, type, numberOfLives);
    }

    @Override
    public String toString() {
        return "Ship{" +
                "shipCoordinates=" + shipCoordinates +
                ", type=" + type +
                '}';
    }

    public Coordinate getStartCoordinate() {
        return shipCoordinates.startCoordinate;
    }

    public Coordinate getEndCoordinate() {
        return shipCoordinates.endCoordinate;
    }

    /**
     * Method checks whether current ship is overlap other ship.
     *
     * @param otherShip other ship for which we check collision
     * @return          is overlap other ship
     */
    public boolean isOverlap(Ship otherShip) {
        Iterator<Coordinate> iteratorCurrentShip = this.shipCoordinates.iterator();
        while (iteratorCurrentShip.hasNext()) {
            Coordinate coordinateCurrentShip = iteratorCurrentShip.next();
            Iterator<Coordinate> iteratorOtherShip = otherShip.shipCoordinates.iterator();
            while (iteratorOtherShip.hasNext()) {
                Coordinate coordinateOtherShip = iteratorOtherShip.next();
                if (coordinateCurrentShip.isAround(coordinateOtherShip)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Shift ship along y axis on value.
     *
     * @param value value of shift.
     */
    public void shiftY(int value) {
        this.shipCoordinates.shiftY(value);
    }

    /**
     * Shift ship along x axis on value.
     *
     * @param value value of shift.
     */
    public void shiftX(int value) {
        this.shipCoordinates.shiftX(value);
    }

    /**
     * Spin ship around starting coordinate.
     */
    public void spin() {
        this.shipCoordinates.spin();
    }

    /**
     * Check whether current ship is hit by shoot
     * @param shoot
     * @return
     */
    public boolean isHit(Coordinate shoot) {
        for (Coordinate shipCoordinate : this.shipCoordinates) {
            if (shipCoordinate.x == shoot.x && shipCoordinate.y == shoot.y) {
                return true;
            }
        }
        return false;
    }
}

