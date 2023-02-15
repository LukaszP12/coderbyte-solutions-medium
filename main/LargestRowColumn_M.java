public class LargestRowColumn_M {

    static int maxSum = 0;

    public static int getLargestRowColumn(String[] strArr) {

        boolean[][] visited = new boolean[strArr.length][strArr[0].length()];

        for (int i = 0; i < strArr.length; i++) {
            for (int j = 0; j < strArr[0].length(); j++) {
                explore(strArr, i, j, 0, visited, 0);
            }
        }

        return maxSum;
    }

    private static void explore(String[] matrix, int y, int x, int sum, boolean[][] visited, int counter) {

        if (y < 0 || y >= matrix.length || x < 0 || x >= matrix[0].length()) {
            return;
        }

        if (visited[y][x] == true) {
            return;
        }

        sum += Integer.parseInt("" + matrix[y].charAt(x));
        counter++;

        if (counter == 3 && withinBounds(sum, matrix) && sum > maxSum) {
            maxSum = sum;
        }

        if (counter > 3) {
            return;
        }

        if (!withinBounds(sum, matrix)) {
            return;
        }

        visited[y][x] = true;

        explore(matrix, y + 1, x, sum, visited, counter);
        explore(matrix, y, x + 1, sum, visited, counter);
        explore(matrix, y, x - 1, sum, visited, counter);
        explore(matrix, y - 1, x, sum, visited, counter);

    }

    private static boolean withinBounds(int sum, String[] matrix) {
        String s = String.valueOf(sum);

        if (s.length() == 1) {
            int k = s.charAt(0) - 48;

            if (k >= matrix.length && k >= matrix[0].length()) {
                return false;
            } else {
                return true;
            }

        }

        int i = s.charAt(0) - 48;
        int i1 = s.charAt(1) - 48;

        if (i >= matrix.length) {
            return false;
        }

        if (i1 >= matrix[0].length()) {
            return false;
        }

        return true;
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
