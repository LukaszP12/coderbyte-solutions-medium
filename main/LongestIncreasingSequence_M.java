public class LongestIncreasingSequence_M {

    public static int getLongestIncreasingSequence(int[] arr) {

        int max_count = 0;

        for (int i = 0; i < arr.length; i++) {

            int j = i;
            int previous = arr[i];
            int counter = 1;

            while (j < arr.length) {
                if (previous < arr[j]) {
                    counter++;
                    previous = arr[j];
                }
                if (max_count < counter) {
                    max_count = counter;
                }

                j++;
            }

        }

        return max_count;
    }

    public static void main(String[] args) {
        int[] ints = {9, 9, 4, 2};
        System.out.println(getLongestIncreasingSequence(ints));

        int[] ints1 = {10, 22, 9, 33, 21, 50, 41, 60, 22, 68, 90};
        System.out.println(getLongestIncreasingSequence(ints1));

        // wrongs cases
        int[] ints2 = {10, 12, 4, 6, 100, 2, 56, 34, 79};
        System.out.println(getLongestIncreasingSequence(ints2));
    }
}
