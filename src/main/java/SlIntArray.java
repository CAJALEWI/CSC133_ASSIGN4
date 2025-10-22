import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SlIntArray {
    protected int NUM_COLS;
    protected int[][] arrayData;
    protected int NUM_ROWS;

    public SlIntArray(int rows, int cols) {
        NUM_ROWS = rows;
        NUM_COLS = cols;
        arrayData = new int[rows][cols];
    }

    public int[] randomizeViaFisherYatesKnuth(int length) {
        int [] array1D = new int[length];
        System.out.println();
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                array1D[((row * NUM_ROWS) + col)] = arrayData[row][col];
            }
        }

        int [] randomArray = SlRandomArray.randomizeIntegerArray(array1D);
        int rowIndex;
        int colIndex;

        for (int arrayIndex = 0; arrayIndex < (NUM_COLS * NUM_ROWS); arrayIndex++) {
            rowIndex = arrayIndex / NUM_COLS;
            colIndex = arrayIndex % NUM_COLS;
            arrayData[rowIndex][colIndex] = randomArray[arrayIndex];
        }

        return randomArray;
    }

    public int[][] loadFile(String fileName) {
        int[][] fileArray = new int[NUM_ROWS][NUM_COLS];
        int row = 0;
        int col = 0;
        try (Scanner fileScanner = new Scanner(new File("src/test/java/" + fileName))) {
            while (fileScanner.hasNextLine()) {
                String fileLine = fileScanner.nextLine();
                String [] lineNumbers = fileLine.split(" +");
                col = lineNumbers.length;
                //System.out.println(col);
                //System.out.println();
                //for (int i = 0; i < col; i++) {
                //    System.out.print(lineNumbers[i] + "  ");
                //}
                row++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("No File Found");
        }
        return fileArray;
    }

}
