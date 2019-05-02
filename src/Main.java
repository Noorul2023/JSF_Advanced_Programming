import controller.CellController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CellController cellController = new CellController();
        cellController.getCellRepository().printGrid();

        Scanner input = new Scanner(System.in);

        while (input.hasNext()) {
            if (!cellController.getCellRepository().isFull()) {
                String inputResult = input.next();
                switch (inputResult) {
                    case "i":
                        cellController.moveUp();
                        break;
                    case "j":
                        cellController.moveLeft();
                        break;
                    case "k":
                        cellController.moveDown();
                        break;
                    case "l":
                        cellController.moveRight();
                        break;
                }
                cellController.getCellRepository().addRandomValue();
                cellController.getCellRepository().printGrid();
            }
        }
    }
}
