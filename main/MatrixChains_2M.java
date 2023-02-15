public class MatrixChains_2M {
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

            int index = getSmallestCombination(arr);

            total += arr[index - 1] * arr[index] * arr[index + 1];
            int[] newArr = getNewArr(arr, index);
            exploreChains(newArr, total);
        }
    }

    private static int getSmallestCombination(int[] arr) {

        int minMultiply = Integer.MAX_VALUE;
        int index = 0;

        for (int i = 1; i < arr.length - 1; i++) {
            int multiply = arr[i - 1] * arr[i] * arr[i + 1];
            if (minMultiply > multiply) {
                minMultiply = multiply;
                index = i;
            }
        }

        return index;
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
//
        int[] ints1 = {1, 4, 5, 6, 8};
//        System.out.println(MatrixChains(ints1));
//
//        int[] ints2 = {10, 2, 4, 12, 15, 20, 4, 56};
////        System.out.println(MatrixChains(ints2));
//
        int[] ints3 = {5, 6, 7, 8, 9, 1, 1, 1, 2};
        System.out.println(MatrixChains(ints3));
        // 5, 6, 7, 8, 9, 1, 1, 1, 2
        // 1 * 1 * 1
        // 5, 6, 7, 8, 9, 1, 1, 2
        // 1 * 1 * 2
        // 5, 6, 7, 8, 9, 1, 2
        // 9 * 1 * 2
        // 5, 6, 7, 8, 9, 2
        // 8 * 9 * 2
        // 5, 6, 7, 8, 2
        // 8 * 9 * 2

//
//        // time out
        int[] ints4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 20, 25, 30, 50, 60, 61, 61, 62};
//        System.out.println(MatrixChains(ints4));
////
//        int[] ints5 = {10, 20, 100, 5, 4, 6, 9, 1, 2, 3, 5, 10, 9, 71};
////        System.out.println(MatrixChains(ints5));
//    }

    }
}