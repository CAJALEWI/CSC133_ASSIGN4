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
        try (Scanner fileScanner = new Scanner(new File("src/test/java/" + fileName))) {
            int defaultValue = fileScanner.nextInt();
            int rowMax = fileScanner.nextInt();
            int colMax = fileScanner.nextInt();
            fileArray = new int[rowMax][colMax];

            for (int row = 0; row < rowMax; row++) {
                for (int col = 0; col < colMax; col++) {
                    fileArray[row][col] = defaultValue;
                }
            }

            while (fileScanner.hasNextLine()) {
                int row = fileScanner.nextInt();
                int col = fileScanner.nextInt();
                String fileLine = fileScanner.nextLine();
                fileLine = fileLine.trim();
                String [] lineNumbers = fileLine.split("\\s+");
                int numAmount = 0;
                for(int index = 0; index < lineNumbers.length; index++) {
                    numAmount++;
                }
                int [] rowNums = new int[numAmount];
                for(int index = 0; index < lineNumbers.length; index++) {
                    int parsedNum = Integer.parseInt(lineNumbers[index]);
                    rowNums[index] = parsedNum;

                }

                int numsIndex = 0;
                for (int arrayCol = 0; arrayCol < colMax; arrayCol++) {
                    if (numsIndex < (rowNums.length) && arrayCol >= col) {
                            fileArray[row][arrayCol] = rowNums[numsIndex];
                            numsIndex++;
                    }
                }
            }
            this.arrayData = fileArray;
            return arrayData;
        } catch (FileNotFoundException e) {
            System.out.println("No File Found");
        }
        this.arrayData = fileArray;
        return arrayData;
    }

    protected int[][] getClone() {
        int[][] clonedArray = new int[NUM_ROWS][NUM_COLS];
        int[] array1D = new int[NUM_ROWS * NUM_COLS];
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                array1D[((row * NUM_ROWS) + col)] = arrayData[row][col];
            }
        }

        int [] cloned1DArray = array1D.clone();

        int rowIndex;
        int colIndex;

        for (int arrayIndex = 0; arrayIndex < (NUM_COLS * NUM_ROWS); arrayIndex++) {
            rowIndex = arrayIndex / NUM_COLS;
            colIndex = arrayIndex % NUM_COLS;
            clonedArray[rowIndex][colIndex] = cloned1DArray[arrayIndex];
        }
        if (clonedArray == arrayData) {
            System.out.println("hi");
        }
        return clonedArray;
    }

}
