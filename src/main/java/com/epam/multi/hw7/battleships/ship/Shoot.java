package com.epam.multi.hw7.battleships.ship;

/**
 * Class represents shoot of players
 */
public class Shoot extends Coordinate {
    public boolean isHit = false;

    public Shoot(int x, int y, boolean isHit) {
        super(x, y);
        this.isHit = isHit;
    }

    @Override
    public String toString() {
        return "Shoot{" +
                "isHit=" + isHit +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

}
