public class SlPingPongArray {
    public SlIntArray cellArrayB;
    public SlIntArray nextCellArray;
    private final String DEFAULT_OUTPUT_FILE = "OutULTOutput.txt";
    public SlIntArray cellArrayA;
    protected int DEFAULT_VALUE;
    public SlIntArray liveCellArray;
    public int MAX_VALUE;
    public final static int ALIVE = 1;
    public int MIN_VALUE;
    public final static int DEAD = 0;

    public SlPingPongArray(int rows, int cols, int defaultV, int huh) {
        this.nextCellArray = new SlIntArray(rows, cols);
        this.DEFAULT_VALUE = defaultV;
        this. MIN_VALUE = 0;
        this. MAX_VALUE = 10;
    }

    public SlPingPongArray(int rows, int cols) {
        nextCellArray = new SlIntArray(rows, cols);
    }


}
