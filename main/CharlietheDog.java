package JavaRegex;

public class CharlietheDog {

//    4x4 matrix of the characters 'C', 'H', 'F', 'O',
//    1. where C represents Charlie the dog,
//    2. H represents its home,
//    3. F represents dog food,
//    and O represents and empty space in the grid.

    private static int min = Integer.MAX_VALUE;
    private static int numFood = 0;


    public static String CharlietheDog(String[] strArr) {
        char[][] grid = new char[strArr.length][strArr[0].length()];
        int cRow = -1;
        int cCol = -1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = strArr[i].charAt(j);

                if (grid[i][j] == 'C') {
                    cRow = i;
                    cCol = j;
                } else if (grid[i][j] == 'F') {
                    numFood++;
                }
            }
        }

        exploreWays(grid, cRow, cCol, 0, 0);

        return String.valueOf(min);
    }

    private static void exploreWays(char[][] grid, int row, int col, int steps, int foodFound) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '.') {
            return;
        }

        if (grid[row][col] == 'H' && foodFound == numFood) {
            min = Math.min(min, steps);
            return;
        }

        char curr = grid[row][col];
        grid[row][col] = '.';

        if (curr == 'F') {
            foodFound++;
        }

        int[] rowOffset = new int[]{-1, 1, 0, 0};
        int[] colOffset = new int[]{0, 0, -1, 1};

        for (int i = 0; i < rowOffset.length; i++) {
            int nextRow = row + rowOffset[i];
            int nextCol = col + colOffset[i];

            exploreWays(grid, nextRow, nextCol, steps + 1, foodFound);
        }

        grid[row][col] = curr;
    }

    public static void main(String[] args) {
        String[] strings = {"OOOO", "OOFF", "OCHO", "OFOO"};
        String s = CharlietheDog(strings);
        System.out.println(s);

        String[] strings1 = new String[]{"FOOO", "OCOH", "OFOF", "OFOO"};
        String s1 = CharlietheDog(strings1);
        System.out.println(s1);

    }

}
