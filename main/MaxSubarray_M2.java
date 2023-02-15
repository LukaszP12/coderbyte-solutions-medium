public class MaxSubarray_M2 {

    public static int getMaxSubarray(int[] arr) {

        int max_Sum = Integer.MIN_VALUE;

        int sum = 0;


        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum > max_Sum) {
                    max_Sum = sum;
                }
            }
            sum = 0;

            for (int k = 0; k < arr.length - i; k++) {
                sum += arr[k];
                if (sum > max_Sum) {
                    max_Sum = sum;
                }
            }
            sum = 0;

        }

        return max_Sum;
    }


    public static void main(String[] args) {
        int[] ints = {1, -2, 0, 3};
        System.out.println(getMaxSubarray(ints));

        int[] ints1 = {3, -1, -1, 4, 3, -1};
        System.out.println(getMaxSubarray(ints1));

        int[] ints2 = {-4, -5, -6};
        System.out.println(getMaxSubarray(ints2));
    }
}
