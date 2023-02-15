import java.util.Arrays;

public class Consecutive_M2 {

    public static int getConsecutive(int[] arr) {

        Arrays.sort(arr);
        int count = 0;

        for (int i = 1; i < arr.length; i++) {
            count += Math.abs(arr[i] - arr[i - 1]) - 1;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] ints = {5, 10, 15};
        System.out.println(getConsecutive(ints));

        int[] ints1 = {-2, 10, 4};
        System.out.println(getConsecutive(ints1));
    }
}
