import java.util.Arrays;

public class ArrayAddition_M {

    public static boolean getArrayAddition(int[] arr) {
        Arrays.sort(arr);
        int max = arr[arr.length - 1];

        int[] numbers = new int[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            numbers[i] = arr[i];
        }

        int sum = Arrays.stream(numbers).sum();
        if (sum < max) {
            return false;
        }

        boolean[] visited = new boolean[numbers.length];
        return addNumbers(numbers, max, visited);
    }

    private static boolean addNumbers(int[] arr, int max, boolean[] visited) {

        if (max == 0 || !areAllTrue(visited)) {
            return true;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i] == false && max - arr[i] >= 0) {
                visited[i] = true;
                addNumbers(arr, max - arr[i], visited);
            }
            visited[i] = false;
            addNumbers(arr, max - arr[i + 1], visited);
        }

        return false;
    }

    public static boolean areAllTrue(boolean[] array) {
        for (boolean b : array) {
            if (!b) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] ints = {5, 7, 16, 1, 2};
        System.out.println(getArrayAddition(ints));

        int[] ints1 = {3, 5, -1, 8, 12};
        System.out.println(getArrayAddition(ints1));
    }
}
