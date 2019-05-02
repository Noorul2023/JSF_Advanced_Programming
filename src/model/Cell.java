package model;

public class Cell {

    private int x;
    private int y;
    private int number;

    public Cell(int x, int y, int number) {
        this.x = x;
        this.y = y;
        this.number = number;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void merge(Cell cell){
        this.setNumber(this.number + cell.getNumber());
    }
}
