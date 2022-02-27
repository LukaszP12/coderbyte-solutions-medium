package JavaRegex;

public class ArrayMinJumps3 {

    public static int ArrayMinJumps3(int[] arr) {

        if (arr.length <= 1) {
            return 0;
        }
        if (arr[0] == 0) {
            return -1;
        }
        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;

        for (int i = 1; i < arr.length; i++) {

            if (i == arr.length - 1)
                return jump;
            maxReach = Math.max(maxReach, i + arr[i]);
            step--;
            if (step == 0) {
                jump++;
                if (i >= maxReach)
                    return -1;
                step = maxReach - i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints1 = {3, 4, 2, 1, 1, 100};
        int[] ints2 = {1, 3, 6, 8, 2, 7, 1, 2, 1, 2, 6, 1, 2, 1, 2};

        System.out.println(ArrayMinJumps3(ints1));
        System.out.println(ArrayMinJumps3(ints2));
    }
}
