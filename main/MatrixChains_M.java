public class MatrixChains_M {

    static int minMultiply = Integer.MAX_VALUE;

    public static int MatrixChains(int[] arr) {
        exploreChains(arr, 0);

        return minMultiply;
    }

    public static void exploreChains(int[] arr, int total) {

        if (arr.length == 2) {
            if (minMultiply > total) {
                minMultiply = total;
            }
        }

        for (int i = 1; i < arr.length - 1; i++) {
            total += arr[i - 1] * arr[i] * arr[i + 1];
            int[] newArr = getNewArr(arr, i);
            exploreChains(newArr, total);
            total -= arr[i - 1] * arr[i] * arr[i + 1];
        }
    }

    private static int[] getNewArr(int[] arr, int i) {
        int[] newArr = new int[arr.length - 1];

        int k = 0;
        for (int j = 0; j < arr.length; j++) {
            if (j != i) {
                newArr[k] = arr[j];
                k++;
            }
        }

        return newArr;
    }

    public static void main(String[] args) {
        int[] ints = {2, 3, 4};
//        System.out.println(MatrixChains(ints));

        int[] ints1 = {1, 4, 5, 6, 8};
//        System.out.println(MatrixChains(ints1));

        int[] ints2 = {10, 2, 4, 12, 15, 20, 4, 56};
//        System.out.println(MatrixChains(ints2));

        int[] ints3 = {5, 6, 7, 8, 9, 1, 1, 1, 2};
//        System.out.println(MatrixChains(ints3));

        // time out
        int[] ints4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 20, 25, 30, 50, 60, 61, 61, 62};
//        System.out.println(MatrixChains(ints4));
//
        int[] ints5 = {10, 20, 100, 5, 4, 6, 9, 1, 2, 3, 5, 10, 9, 71};
//        System.out.println(MatrixChains(ints5));

//        1, 2, 3, 4, 5, 6, 7, 8, 9, 20, 25, 30, 50, 60, 61, 61, 62
//        1 * 2 * 3 = 6
//        1, 3, 4, 5, 6, 7, 8, 9, 20, 25, 30, 50, 60, 61, 61, 62
//        1 * 3 * 4  = 12
//        1, 4, 5, 6, 7, 8, 9, 20, 25, 30, 50, 60, 61, 61, 62
//        1 * 4 * 5  = 20
//        1, 5, 6, 7, 8, 9, 20, 25, 30, 50, 60, 61, 61, 62
//        1 * 5 * 6 = 30
//        1,6, 7, 8, 9, 20, 25, 30, 50, 60, 61, 61, 62
//        1 * 6 * 7 = 42
//        1, 7, 8, 9, 20, 25, 30, 50, 60, 61, 61, 62
//        1 * 7 * 8 = 56
//        1, 8, 9, 20, 25, 30, 50, 60, 61, 61, 62
//        1 * 8 * 9 = 72
//        1, 9, 20, 25, 30, 50, 60, 61, 61, 62
//        1 * 9 * 20 = 180
//        1, 20, 25, 30, 50, 60, 61, 61, 62
//        1 * 20 * 25 = 500
//        1, 25, 30, 50, 60, 61, 61, 62
//        1 * 25 * 30 = 750
//        1, 30, 50, 60, 61, 61, 62
//        1 * 30 * 50 = 1500
//        1, 50, 60, 61, 61, 62
//        1 * 50 * 60 = 3000
//        1, 60, 61, 61, 62
//        1 * 60 * 61 = 3660
//        1, 61, 61, 62
//        1 * 61 * 61 = 3721
//        1, 61, 62
//        1 * 61 * 62 = 3782

        // 1, 4, 5, 6, 8
        // 1 * 4 * 5

        // 1, 5, 6, 8
        // 1 * 5 * 6

        // 1,6,8
        // 1*6*8

        // 1,8


        // 1*4*5, 6, 8
        // 20

        // 1,5,6,8
        // 1*5*6,8
        // 20 + 30

        // 1,6,8
        // 20 + 30 + 48

    }

}
