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
        nextCellArray.arrayData[row][col] += ALIVE;
    }

    void setCellDead(int row, int col) {
        nextCellArray.arrayData[row][col] = DEAD;
    }

    public void setCell(int row, int col, int value) {
        nextCellArray.arrayData[row][col] = value;
    }

    public int getNNNSum(int row, int col) {
        int nextRow = row + 1;
        int nextCol = col + 1;
        int nnnSum = 0;
        int finalRow = liveCellArray.NUM_ROWS - 1;
        int finalCol = liveCellArray.NUM_COLS - 1;

        for (int blockRow = row - 1; blockRow <= nextRow; blockRow++) {
            for (int blockCol = col - 1; blockCol <= nextCol; blockCol++) {
                if (blockRow < 0 && blockCol < 0 ||
                        blockRow < 0 && blockCol > finalCol ||
                        blockRow > finalRow && blockCol < 0 ||
                        blockRow > finalRow && blockCol > finalCol) {
                    nnnSum += liveCellArray.arrayData[(blockRow + liveCellArray.NUM_ROWS)
                            % liveCellArray.NUM_ROWS][(blockCol + liveCellArray.NUM_COLS)
                            % liveCellArray.NUM_COLS];
                } // 4 corners
                else if (blockRow < 0 || blockRow > finalRow) {
                    nnnSum += liveCellArray.arrayData[(blockRow + liveCellArray.NUM_ROWS)
                            % liveCellArray.NUM_ROWS][blockCol];
                } // up and down
                else if (blockCol < 0 || blockCol > finalCol) {
                    nnnSum += liveCellArray.arrayData[blockRow][(blockCol + liveCellArray.NUM_COLS)
                            % liveCellArray.NUM_COLS];
                } // left and right
                else {
                    nnnSum += liveCellArray.arrayData[blockRow][blockCol];
                    if (blockRow == row && blockCol == col) {
                        nnnSum -= liveCellArray.arrayData[blockRow][blockCol];
                    } // exclude adding middle value
                } // everything in the middle
            }
        }
        return nnnSum;
    }

}
