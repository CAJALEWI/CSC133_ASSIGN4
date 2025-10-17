public class Main {
    public static void main(String[] myArgs) {
        int myRows = 14, myCols = 8;
        SlPingPongArray myPPA = new SlPingPongArray(myRows, myCols, 0, 0);
        int[][] fileArray = myPPA.nextCellArray.loadFile("src/main/java/ult_input_1.txt");
    }  //  public static void main(String[] myArgs)
}
