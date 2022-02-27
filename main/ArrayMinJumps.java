package JavaRegex;

public class ArrayMinJumps {

    public static int ArrayMinJumps(int[] arr) {
        if (arr[0] == 0) return -1;
        int len = arr.length;
        if (len == 1) return 0;

        int min;
        int[] jumps = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            min = Integer.MAX_VALUE;
            if (arr[i] == 0) {
                jumps[i] = min;
            } else if ((i + arr[i]) - (len - 1) >= 0) {
                jumps[i] = 1;
            } else {
                for (int j = 1; j <= Math.min(arr[i], (len - 1 - i)); j++) {
                    if (jumps[i + j] < Integer.MAX_VALUE) {
                        min = Math.min(min, 1 + jumps[i + j]);
                    }
                    jumps[i] = min;
                }
            }
        }
        return jumps[0] == Integer.MAX_VALUE ? -1 : jumps[0];
    }

    public static void main(String[] args) {
        int[] ints1 = {3, 4, 2, 1, 1, 100};
        int[] ints2 = {1, 3, 6, 8, 2, 7, 1, 2, 1, 2, 6, 1, 2, 1, 2};

        System.out.println(ArrayMinJumps(ints1));
        System.out.println(ArrayMinJumps(ints2));
    }

}
