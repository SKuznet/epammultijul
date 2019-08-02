package com.epam.multi.hw7.battleships.ship;

import com.epam.battleships.player.Grid;

import java.util.Objects;
import java.util.Random;

/**
 * Class represents 2 dim coordinates on grid.
 */
public class Coordinate {
    public int x;
    public int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Method returs next random coordinate within grid
     *
     * @return random coordinate
     */
    public static Coordinate nextRandomCoordinate() {
        Random random = new Random();
        return new Coordinate(random.nextInt(Grid.getRowAndColumnNumber()),
                random.nextInt(Grid.getRowAndColumnNumber()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    /**
     * Method returns new coordinate that shifted on y axis.
     * @param value value of shift.
     * @return      new shifted coordinate.
     */
    public Coordinate plusY(int value) {
        return new Coordinate(this.x, this.y + value);
    }

    /**
     * Method returns new coordinate that shifted on x axis.
     *
     * @param value value of shift.
     * @return      new shifted coordinate.
     */
    public Coordinate plusX(int value) {
        return new Coordinate(this.x + value, this.y);
    }

    /**
     * Check if chosen coordinate is around current coordinate
     *
     * @param otherCoordinate other coordinate
     * @return                true if other coordinate is around this.coordinate
     */
    public boolean isAround(Coordinate otherCoordinate) {
        if (this.x <= otherCoordinate.x + 1
                && this.x >= otherCoordinate.x - 1
                && this.y <= otherCoordinate.y + 1
                && this.y >= otherCoordinate.y - 1) {
            return true;
        } else {
            return false;
        }
    }
}
