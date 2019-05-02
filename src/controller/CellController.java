package controller;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import model.Cell;
import repository.CellRepository;

import static repository.CellRepository.SIZE;

@ManagedBean
@ApplicationScoped

public class CellController {

    private CellRepository cellRepository;

    //public enum Direction {UP, DOWN, LEFT, RIGHT}

    public CellController() {
        cellRepository = new CellRepository();
    }

    public CellRepository getCellRepository() {
        return cellRepository;
    }

    public Cell[][] getGrid() {
        return cellRepository.getGrid();
    }

    public void moveUp() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cellRepository.moveUp(cellRepository.getGrid()[i][j]);
            }
        }
        cellRepository.addRandomValue();
    }

    public void moveDown() {
        for (int i = SIZE - 1; i >= 0; i--) {
            for (int j = 0; j < SIZE; j++) {
                cellRepository.moveDown(cellRepository.getGrid()[i][j]);
            }
        }
        cellRepository.addRandomValue();
    }

    public void moveLeft() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cellRepository.moveLeft(cellRepository.getGrid()[i][j]);
            }
        }
        cellRepository.addRandomValue();
    }

    public void moveRight() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = SIZE - 1; j >= 0; j--) {
                cellRepository.moveRight(cellRepository.getGrid()[i][j]);
            }
        }
        cellRepository.addRandomValue();
    }

}