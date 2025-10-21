public class Main {
    public static void main(String[] myArgs) {
        int myRows = 14, myCols = 8;
        SlPingPongArray myPPA = new SlPingPongArray(7, 7);
        int[][] fileArray = myPPA.nextCellArray.loadFile("src/main/java/ult_input_1.txt");
        myPPA.swapLiveAndNext();
        System.out.println("Input array:");
        myPPA.printArray();
    }  //  public static void main(String[] myArgs)
}
