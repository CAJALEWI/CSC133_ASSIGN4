import java.util.Random;

public class SlRandomArray {
    public SlRandomArray() { }
    public static int [] randomizeIntegerArray(int[] regArray){
        int index = regArray.length - 1;
        Random indexRandomizer = new Random();
        while(index > 0) {
            int rIndex = indexRandomizer.nextInt(index);
            int tmpSwapBuffer = regArray[rIndex];
            regArray[rIndex] = regArray[index];
            regArray[index] = tmpSwapBuffer;

            index--;
        }
        return(regArray);
    }
}
