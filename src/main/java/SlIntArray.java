public class SlIntArray {
    protected int NUM_COLS;
    protected int[][] arrayData;
    protected int NUM_ROWS;

    public SlIntArray(int rows, int cols) {
        NUM_ROWS = rows;
        NUM_COLS = cols;
        arrayData = new int[rows][cols];
    }



}
