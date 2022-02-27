package JavaRegex;


import java.util.Stack;

public class NearestSmallerValues3 {

    public static String NearestSmallerValues(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        String output = "";
        for (int i = 0; i < arr.length; i++) {
            while (!stack.empty() && stack.peek() > arr[i]) {
                stack.pop();
            }

            if (stack.empty()) output += "-1";
            else output += stack.peek() + " ";

            stack.push(arr[i]);
        }

        return output;
    }

    public static void main(String[] args) {
        int[] ints = {5, 3, 1, 9, 7, 3, 4, 1};
        int[] ints1 = {2, 4, 5, 1, 7};

        System.out.println(NearestSmallerValues(ints));
        System.out.println(NearestSmallerValues(ints1));

    }

}
