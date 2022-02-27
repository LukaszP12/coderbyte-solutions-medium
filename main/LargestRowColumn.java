package JavaRegex;

import java.util.ArrayList;
import java.util.List;

public class LargestRowColumn {

    public static String LargestRowColumn(String[] strArr) {

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < strArr.length; i++) {
            String row = strArr[i];
            matrix.add(new ArrayList<>());
            for (int j = 0; j < row.length(); j++) {
                Integer number = Integer.parseInt(row.charAt(j) + "");
                matrix.get(i).add(number);
            }
        }

        int max = 0;
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(0).size(); j++) {
                max = Math.max(max, walk(matrix, i, j, 1, 0));
            }

            return String.valueOf(max);
        }


        // code goes here
        return strArr[0];
    }

    public static int walk(List<List<Integer>> matrix, int i, int j, int count, int sum) {
        if (i < 0 || i == matrix.size() || j < 0 || j == matrix.get(0).size()) {
            return 0;
        }

        int cellValue = matrix.get(i).get(j);

        if (count == 3) {
            if (evaluateSum(matrix, sum + cellValue)) {
                return sum + cellValue;
            }
        } else {
            return 0;
        }

        return 0;
    }

    public static boolean evaluateSum(List<List<Integer>> matrix, int number) {
        int row = number / 10;
        int col = number % 10;
        return !(row >= matrix.size() || col >= matrix.get(0).size());
    }

    public static void main(String[] args) {
        String[] strings = {"234", "999", "999"};

        String[] strings1 = {"11111", "22222"};
    }

}
