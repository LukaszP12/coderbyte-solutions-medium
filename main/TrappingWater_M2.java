import java.util.ArrayDeque;

public class TrappingWater_M2 {

    public static int getTrappingWater(int[] arr) {
        int trapped = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int index = 0; index < arr.length; index++) {
            while (!stack.isEmpty() && arr[index] >= arr[stack.peek()]) {
                int b = stack.pollFirst();
                if (!stack.isEmpty()) {
                    int leftIndex = stack.peek();
                    int leftBound = arr[leftIndex];
                    int minHeight = Math.min(leftBound, arr[index]) - arr[b];
                    int width = index - leftIndex - 1;
                    trapped += (minHeight * width);
                }
            }
            stack.addFirst(index);
        }
        return trapped;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 1, 2};
        System.out.println(getTrappingWater(ints));

        int[] ints1 = {0, 2, 4, 0, 2, 1, 2, 6};
        System.out.println(getTrappingWater(ints1));
    }
}
