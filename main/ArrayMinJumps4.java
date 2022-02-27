package JavaRegex;

public class ArrayMinJumps4 {

    public static int ArrayMinJumps4(int[] arr) {
        int result[] = new int[arr.length];
        result[0] = 0;
        for (int i = 0; i < result.length - 1; i++) {
            int steps = arr[i];
            int val = result[i] + 1;
            for (int j = i + 1; j < (result.length) && j < (i + 1 + steps); j++) {
                if (result[j] == 0) {
                    result[j] = val;
                }
            }
        }
        return result[arr.length - 1];
    }

    public static void main(String[] args) {
        int[] ints1 = {3, 4, 2, 1, 1, 100};
        int[] ints2 = {1, 3, 6, 8, 2, 7, 1, 2, 1, 2, 6, 1, 2, 1, 2};

        System.out.println(ArrayMinJumps4(ints1));
        System.out.println(ArrayMinJumps4(ints2));
    }
}
