import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SlPingPongArray extends SlIntArray {
    public SlIntArray cellArrayB;
    public SlIntArray nextCellArray;
    private final String DEFAULT_OUTPUT_FILE = "pps_data.txt";
    public SlIntArray cellArrayA;
    protected int DEFAULT_VALUE;
    public SlIntArray liveCellArray;
    public int MAX_VALUE;
    public final static int DEAD = 0;
    public final static int ALIVE = 1;
    public int MIN_VALUE;


    public SlPingPongArray(int rows, int cols, int defaultV, int huh) {
        super(rows, cols);
        this.nextCellArray = new SlIntArray(rows, cols);
        this.DEFAULT_VALUE = defaultV;
        this. MIN_VALUE = 0;
        this. MAX_VALUE = 10;
    }

    public SlPingPongArray(int rows, int cols) {
        super(rows, cols);
        nextCellArray = new SlIntArray(rows, cols);
    }

    public void swapLiveAndNext() {
        SlIntArray tmp = nextCellArray;
        nextCellArray = liveCellArray;
        liveCellArray = tmp;
    }

    public void printArray() {
        for (int row = 0; row < liveCellArray.NUM_ROWS; row++) {
            for (int col = 0; col < liveCellArray.NUM_COLS; col++) {
                System.out.print(liveCellArray.arrayData[row][col] + "  ");
            }
            System.out.println();
        }
    }

    public void randomizeViaFisherYatesKnuth() {
        int [] array1D = nextCellArray.randomizViaFisherYatesKnuth(NUM_ROWS * NUM_COLS);
        int rowIndex;
        int colIndex;

        for (int arrayIndex = 0; arrayIndex < (NUM_COLS * NUM_ROWS); arrayIndex++) {
            rowIndex = arrayIndex / NUM_COLS;
            colIndex = arrayIndex % NUM_COLS;
            nextCellArray.arrayData[rowIndex][colIndex] = array1D[arrayIndex];
        }
    }

    //public int[][] loadedFile(String fileName) {
    //    nextCellArray.loadFile(fileName);
    //    return nextCellArray.arrayData;
    //}

}
