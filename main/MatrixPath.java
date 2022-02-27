package JavaRegex;

import java.util.Arrays;

public class MatrixPath {

    public static String MatrixPath(String[] inputCondensedArray) {
        int columnNumber = inputCondensedArray[0].length();
        int rowNumber = inputCondensedArray.length;
        int[][] actualMatrix = new int[rowNumber][columnNumber];
        int mainIndexThroughMatrix = 0;
        int numberOfPaths = 0;

        for (String row : inputCondensedArray) {
            actualMatrix[mainIndexThroughMatrix] = Arrays.stream(row.split("(?<=[0-1])")).mapToInt(Integer::parseInt).toArray();
        }

        actualMatrix[0][0] = 3;
        actualMatrix[rowNumber - 1][columnNumber - 1] = 2;

        if (pathExists(actualMatrix, columnNumber, rowNumber))
            return "true";


        return "";
    }

    private static boolean pathExists(int[][] actualMatrix, int columnNumber, int rowNumber) {
        return false;
    }

    public static void main(String[] args) {
        String[] strings = {"10000", "11011", "10101", "11001"};
    }

}
