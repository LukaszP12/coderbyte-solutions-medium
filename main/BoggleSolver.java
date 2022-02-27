package JavaRegex;

import java.util.Arrays;

public class BoggleSolver {

//    1. A word can be constructed from sequentially adjacent spots in the matrix,
//    where adjacent means moving horizontally, vertically, or diagonally in any direction.
//        2. A word cannot use the same location twice to construct itself.

    public static String BoggleSolver(String[] strArr) {
        String[] words = strArr[1].split(",");
        String[] rows = strArr[0].split(", ");
        StringBuilder res = new StringBuilder();
        char[][] grid = new char[rows.length][rows.length];

        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows.length; j++) {
                grid[i][j] = rows[i].charAt(j);
            }
        }

        for (String word : words) {
            if (word.length() > 16) {
                continue;
            }

//            if (!hasValidConstruction(word, gridCopy)) {
//
//            }

        }

        return strArr[0];
    }

    private static boolean hasValidConstruction(String word, char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (canConstructWord(word, grid, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean canConstructWord(String word, char[][] grid, int row, int col) {
        if (word.isEmpty()) {
            return true;
        }

        char ch = word.charAt(0);

        return false;
    }

    public static void main(String[] args) {
        String[] strings = {"aaey, rrum, tgmn, ball", "all,ball,mur,raeymnl,tall,true,trum"};
        String[] strings1 = {"aaey, rrum, tgmn, ball", "all,ball,mur,raeymnl,rumk,tall,true,trum,yes"};

    }

}


