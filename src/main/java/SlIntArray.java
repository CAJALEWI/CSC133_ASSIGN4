public class SlIntArray {
    protected int NUM_COLS;
    protected int[][] arrayData;
    protected int NUM_ROWS;

    public SlIntArray(int rows, int cols) {
        NUM_ROWS = rows;
        NUM_COLS = cols;
        arrayData = new int[rows][cols];
    }

    public int[] randomizViaFisherYatesKnuth(int length) {
        int [] randomArray = new int[length];
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                randomArray[row * NUM_ROWS + col] = arrayData[row][col];
            }
        }
        return randomArray;
    }

}
