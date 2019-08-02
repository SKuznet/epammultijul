package com.epam.multi.hw7.battleships.player;

import com.epam.battleships.ship.Coordinate;
import com.epam.battleships.ship.Ship;
import com.epam.battleships.ship.Shoot;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Class represent battleship field using square table.
 * This class have special methods to map shoots tracks, ships and shoot pointer to cells of grid.
 * There is also draw() method to print grid to terminal
 */
public class Grid {
    private static int rowAndColumnNumber;

    static {
        String result = ResourceBundle.getBundle("settings").getString("gridSize");
        rowAndColumnNumber = Integer.parseInt(result);
    }

    public Coordinate shootPointer = new Coordinate(rowAndColumnNumber / 2, rowAndColumnNumber / 2);
    public String[][] cellsValues;

    public Grid() {
        cellsValues = new String[rowAndColumnNumber][rowAndColumnNumber];
        for (int i = 0; i < rowAndColumnNumber; ++i) {
            for (int j = 0; j < rowAndColumnNumber; ++j) {
                cellsValues[i][j] = " ";
            }
        }
    }


    public static int getRowAndColumnNumber() {
        return rowAndColumnNumber;
    }

    /**
     * Check whether chosen coordinate is out of grid bounds.
     *
     * @param coordinate chosen coordinate
     * @return is out of bounds
     */
    public static boolean isOutOfBounds(Coordinate coordinate) {
        return !((coordinate.x <= rowAndColumnNumber - 1) && (coordinate.x >= 0) &&
                (coordinate.y <= rowAndColumnNumber - 1) && (coordinate.y >= 0));
    }

    /**
     * Print grid's values to terminal
     */
    public void draw() {
        drawFirstLine();
        for (int i = 0; i < rowAndColumnNumber; i++) {
            for (int j = 0; j < rowAndColumnNumber; j++) {
                String currentSymbol = cellsValues[i][j];
                if (j == 0) {
                    if (i == rowAndColumnNumber - 1) {
                        System.out.print((i) + " | " + currentSymbol + " | ");
                    } else {
                        System.out.print((i) + " | " + currentSymbol + " | ");
                    }
                } else {
                    System.out.print(currentSymbol + " | ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Print first line (x axis)
     */
    private void drawFirstLine() {
        StringBuilder firstLine = new StringBuilder();
        firstLine.append("    ");
        for (int currentChar = 0; currentChar <= 9; ++currentChar) {
            firstLine.append(currentChar);
            firstLine.append("   ");
        }
        System.out.println(firstLine.toString());
    }

    /**
     * Reset values of grid's cells
     */
    public void clearCells() {
        for (String[] cellsValue : cellsValues) {
            for (int i = 0; i < cellsValue.length; ++i) {
                cellsValue[i] = " ";
            }
        }
    }

    /**
     * Map ships to grid.
     * If player is placing ships, map first unplaced and all placed ships to grid, else map all ships to grid.
     *
     * @param ships input player's ships
     */
    public void useHumanPlayerShips(List<Ship> ships) {
        clearCells();
        Optional<Ship> ship = ships.stream().filter(currShip -> !currShip.isPlaced()).findFirst();
        if (!ship.isPresent()) {
            useShips(ships);
        } else {
            ArrayList<Ship> currentShips = ships.stream()
                    .filter(s -> s.isPlaced()).collect(Collectors.toCollection(ArrayList::new));
            currentShips.add(ship.get());
            useShips(currentShips);
        }
    }

    /**
     * Map shoots, dead enemy ships and shoot pointer to grid.
     * Used to display enemy grid.
     *
     * @param deadShips list of dead enemy ships to draw
     * @param shoots    list of player shoots
     */
    public void draw(Set<Ship> deadShips, ArrayList<Shoot> shoots) {
        clearCells();
        useShoots(shoots);
        useShips(deadShips);
        usePointer();
        draw();
    }

    /**
     * Map enemy shoots and own ships to grid.
     * Used to display own grid.
     *
     * @param ships  list of ships to draw.
     * @param shoots list of enemy player shoots.
     */
    public void draw(List<Ship> ships, ArrayList<Shoot> shoots) {
        useHumanPlayerShips(ships);
        useShoots(shoots);
        draw();
    }

    /**
     * Map shoot pointer to grid
     */
    private void usePointer() {
        if (!Grid.isOutOfBounds(shootPointer)) {
            cellsValues[shootPointer.x][shootPointer.y] = "*";
        }
    }

    /**
     * Map shoots to grid.
     * use symbol '-' if missed the shoot and 'X" if hit.
     *
     * @param shoots list of shoots
     */
    public void useShoots(ArrayList<Shoot> shoots) {
        for (Shoot shoot : shoots) {
            if (!Grid.isOutOfBounds(shoot)) {
                cellsValues[shoot.x][shoot.y] = shoot.isHit ? "X" : "-";
            }
        }
    }

    /**
     * Map ships to grid.
     *
     * @param ships list of ships.
     */
    private void useShips(Collection<Ship> ships) {
        for (Ship deadShip : ships) {
            for (Coordinate coordinate : deadShip.getShipCoordinates()) {
                if (!isOutOfBounds(coordinate)) {
                    cellsValues[coordinate.x][coordinate.y] = deadShip.getType().toString();
                }
            }
        }
    }

}


