package repository;

import model.Cell;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CellRepository {

    public static final int SIZE = 4;
    private Cell[][] grid = new Cell[SIZE][SIZE];

    // grid with empty cells
    public CellRepository() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = new Cell(i, j, 0);
            }
        }
        addRandomValue();
        addRandomValue();
    }

    public Cell[][] getGrid() {
        return grid;
    }

    // add random value of 2 or 4

    public void addRandomValue() {
        int x;
        int y;

        if (!isFull()) {
            do {
                x = getRandomPosition();
                y = getRandomPosition();
            } while (!isEmpty(x, y));

            grid[x][y].setNumber(getRandomNumber());
        }
        // else game over
    }

    private int getRandomPosition() {
        Random result = new Random();
        return result.nextInt(SIZE);
    }

    private int getRandomNumber() {
        List<Integer> newNumbers = Arrays.asList(2, 4);
        Random result = new Random();
        return newNumbers.get(result.nextInt(newNumbers.size()));
    }

    // move

    public void moveUp(Cell cell) {
        int x = cell.getX();
        int y = cell.getY();
        int number = cell.getNumber();
        Cell next;

        do {
            x--;
            if (x >= 0) {
                next = grid[x][y];
                if (isEmpty(x, y)) {
                    next.setNumber(number);
                    grid[x + 1][y].setNumber(0);
                } else if (next.getNumber() == grid[x + 1][y].getNumber()) {
                    next.merge(grid[x + 1][y]);
                    grid[x + 1][y].setNumber(0);
                    break;
                } else {
                    break;
                }
            }
        } while (x >= 0);
    }

    public void moveDown(Cell cell) {
        int x = cell.getX();
        int y = cell.getY();
        int number = cell.getNumber();
        Cell next;

        do {
            x++;
            if (x <= SIZE - 1) {
                next = grid[x][y];
                if (isEmpty(x, y)) {
                    next.setNumber(number);
                    grid[x - 1][y].setNumber(0);
                } else if (next.getNumber() == grid[x - 1][y].getNumber()) {
                    next.merge(grid[x - 1][y]);
                    grid[x - 1][y].setNumber(0);
                    break;
                } else {
                    break;
                }
            }
        } while (x <= SIZE - 1);
    }

    public void moveRight(Cell cell) {
        int x = cell.getX();
        int y = cell.getY();
        int number = cell.getNumber();
        Cell next;

        do {
            y++;
            if (y <= SIZE - 1) {
                next = grid[x][y];
                if (isEmpty(x, y)) {
                    next.setNumber(number);
                    grid[x][y - 1].setNumber(0);
                } else if (next.getNumber() == grid[x][y - 1].getNumber()) {
                    next.merge(grid[x][y - 1]);
                    grid[x][y - 1].setNumber(0);
                    break;
                } else {
                    break;
                }
            }
        } while (y <= SIZE - 1);
    }

    public void moveLeft(Cell cell) {
        int x = cell.getX();
        int y = cell.getY();
        int number = cell.getNumber();
        Cell next;

        do {
            y--;
            if (y >= 0) {
                next = grid[x][y];
                if (isEmpty(x, y)) {
                    next.setNumber(number);
                    grid[x][y + 1].setNumber(0);
                } else if (next.getNumber() == grid[x][y + 1].getNumber()) {
                    next.merge(grid[x][y + 1]);
                    grid[x][y + 1].setNumber(0);
                    break;
                } else {
                    break;
                }
            }
        } while (y >= 0);
    }

    // empty cell, full grid

    private boolean isEmpty(int x, int y) {
        return grid[x][y].getNumber() == 0;
    }

    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j].getNumber() == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // print matrix - test

    public void printGrid() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(grid[i][j].getNumber() + "     ");
            }
            System.out.println("\n");
        }
        System.out.println("---------------------\n");
    }

}
