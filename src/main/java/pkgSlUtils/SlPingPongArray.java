package pkgSlUtils;

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


    public SlPingPongArray(int rows, int cols, int defaultV, int minValue, int maxValue) {
        super(rows, cols);
        nextCellArray = new SlIntArray(rows, cols);
        cellArrayA = new SlIntArray(rows, cols);
        cellArrayB = new SlIntArray(rows, cols);
        liveCellArray = new SlIntArray(rows, cols);
        DEFAULT_VALUE = defaultV;
        MIN_VALUE = minValue;
        MAX_VALUE = maxValue;
    }

    public SlPingPongArray(int rows, int cols) {
        super(rows, cols);
        nextCellArray = new SlIntArray(rows, cols);
        cellArrayA = new SlIntArray(rows, cols);
        cellArrayB = new SlIntArray(rows, cols);
        liveCellArray = new SlIntArray(rows, cols);
    }

    public void swapLiveAndNext() {
        SlIntArray tmp = nextCellArray;
        nextCellArray = liveCellArray;
        liveCellArray = tmp;
    }

    public void printArray() {
        for (int row = 0; row < liveCellArray.NUM_ROWS; row++) {
            System.out.printf("%4d|--> ", row);
            for (int col = 0; col < liveCellArray.NUM_COLS; col++) {
                System.out.printf("%3d  ", liveCellArray.arrayData[row][col]);
            }
            System.out.println();
        }
    }

    public void randomizeViaFisherYatesKnuth() {
        nextCellArray = liveCellArray;
        nextCellArray.randomizeViaFisherYatesKnuth(NUM_ROWS * NUM_COLS);
    }

    public int[][] loadFile(String fileName) {
        nextCellArray.loadFile(fileName);
        swapLiveAndNext();
        return liveCellArray.arrayData;
    }

    public void setCellAlive(int row, int col) {
        swapLiveAndNext();
        nextCellArray.arrayData[row][col] += ALIVE;
        swapLiveAndNext();
    }

    void setCellDead(int row, int col) {
        swapLiveAndNext();
        nextCellArray.arrayData[row][col] = DEAD;
        swapLiveAndNext();
    }

    public void setCell(int row, int col, int value) {
        if (value < 2) {
            setCellDead(row, col);
        } else if (value > 3) {
            setCellDead(row, col);
        } else if (value == 3) {
            setCellAlive(row, col);
        }
    }

    public int getNNNSum(int row, int col) {
        return liveCellArray.arrayData[row][col];
    }

}
