public class MatrixSpiral_M {

    public static String MatrixSpiral(String[] strArr) {
        String[][] matrix = toMatrix(strArr);


        int size = matrix[0].length * strArr.length;

        if (size == 1) {
            return "" + matrix[0][0];
        }

        String spiral = "";

        int t = 0; // top
        int r = 0; // right

        // boundaries
        int tb = 0;
        int rb = matrix[0].length;
        int db = matrix.length;
        int lb = 0;

        while (spiral.split(",").length < size) {

            for (; r < rb; ++r) {
                spiral += matrix[t][r] + ",";
            }
            --r;
            tb++;

            t++;
            for (; t < db; t++) {
                spiral += matrix[t][r] + ",";
            }
            --t;
            rb--;

            r--;
            for (; r >= lb; r--) {
                spiral += matrix[t][r] + ",";
            }
            r++;
            db--;

            t--;
            for (; t >= tb; t--) {
                spiral += matrix[t][r] + ",";
            }
            lb++;
            t++;
            r++;
        }

        String result = "";
        String[] split = spiral.split(",");
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                result += split[i];
                break;
            }

            result += split[i] + ",";
        }


        return result.trim();
    }

    private static String[][] toMatrix(String[] strArr) {
        String[] split = strArr[0].substring(1, strArr[0].length() - 1).split(",");

        String[][] matrix = new String[strArr.length][split.length];

        for (int i = 0; i < strArr.length; i++) {
            String[] strings = strArr[i].substring(1, strArr[i].length() - 1).split(",");
            for (int j = 0; j < strings.length; j++) {
                matrix[i][j] = strings[j].trim();
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
//        String[] strings = {"[1, 2]", "[10, 14]"};
//        System.out.println(MatrixSpiral(strings));

//        String[] strings1 = {"[4, 5, 6, 5]", "[1, 1, 2, 2]", "[5, 4, 2, 9]"};
//        System.out.println(MatrixSpiral(strings1));

//        String[] strings2 = {"[1, 2, 3]", "[4, 5, 6]", "[7, 8, 9]"};
//        System.out.println(MatrixSpiral(strings2));

//        String[] strings3 = {"[1, 2, 3]"};
//        System.out.println(MatrixSpiral(strings3));

//        String[] strings4 = {"[1, 2, 3, 4, 2]", "[1, 1, 2, 2, 6]", "[7, 8, 10, 12, 99]"};
//        System.out.println(MatrixSpiral(strings4));
//        System.out.println(MatrixSpiral(strings4).equals("1,2,3,4,2,6,99,12,10,8,7,1,1,2,2"));
//
//        String[] strings5 = {"[1, 2, 3, 4, 5]", "[4, 5, 6, 7, 8]", "[7, 8, 9, 10, 11]", "[14, 3, 2, 1, 3]", "[6, 7, 3, 2, 1]"};
//        System.out.println(MatrixSpiral(strings5));
//        System.out.println(MatrixSpiral(strings5).equals("1,2,3,4,5,8,11,3,1,2,3,7,6,14,7,4,5,6,7,10,1,2,3,8,9"));

        String[] strings6 = {"[9]"};
        System.out.println(MatrixSpiral(strings6));

        String[] strings7 = {"[9]", "[1]"};
//        System.out.println(MatrixSpiral(strings7));
    }

}
