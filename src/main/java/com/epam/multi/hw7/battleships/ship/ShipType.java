package com.epam.multi.hw7.battleships.ship;

/**
 * Class represents ship's type and contain string view of ships, number of ships and ship's length.
 */
public enum ShipType {
    BATTLESHIP(1, 4) {
        @Override
        public String toString() {
            return "B";
        }
    },
    CRUISER(2, 3) {
        @Override
        public String toString() {
            return "C";
        }
    },
    DESTROYER(3, 2) {
        @Override
        public String toString() {
            return "D";
        }
    },
    TORPEDO_BOAT(4, 1) {
        @Override
        public String toString() {
            return "T";
        }
    };

    private final int numberShips;
    private final int shipLength;

    ShipType(int numberShips, int shipLength) {
        this.numberShips = numberShips;
        this.shipLength = shipLength;
    }

    public int getNumberShips() {
        return numberShips;
    }

    public int getShipLength() {
        return shipLength - 1;
    }
}
