import java.util.Arrays;

public class LargestRowColumn_2 {

    public static String getLargestRowColumn(String[] strArr) {
        int columnNumber = strArr[0].length();
        int rowNumber = strArr.length;
        int[][] actualMatrix = new int[rowNumber][columnNumber];
        int mainIndexThroughMatrix = 0;
        int numberOfPaths = 0;

        for (String row : strArr) {
            Arrays.stream(row.split("(?<=[0-1])")).mapToInt(Integer::parseInt).toArray();
        }

        actualMatrix[0][0] = 3;
        actualMatrix[rowNumber - 1][columnNumber - 1] = 2;

        if (pathExists(actualMatrix, columnNumber, rowNumber)) {
            return "true";
        }

        return "";
    }

    private static boolean pathExists(int[][] actualMatrix, int columnNumber, int rowNumber) {

        return false;
    }

    public static void main(String[] args) {
        String[] strings1 = {"11111", "22222"};
//        System.out.println(getLargestRowColumn(strings1));

        // wrong case
        String[] strings = {"234", "999", "999"};
//        System.out.println(getLargestRowColumn(strings));

        String[] strings2 = {"345", "326", "221"};
//        System.out.println(getLargestRowColumn(strings2));
    }
}
