package Hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ApproachingFibonacci_M {

    public static int ApproachingFibonacci(int[] arr) {

        int sum = Arrays.stream(arr).sum();

        return nextFib(sum) - sum;
    }

    private static int nextFib(int sum) {
        List<Integer> fib = new LinkedList<>();
        fib.add(0);
        fib.add(1);

        int i = 2;
        while (true) {
            fib.add(fib.get(i - 1) + fib.get(i - 2));
            if (fib.get(i) == sum) {
                return fib.get(i);
            }

            if (fib.get(i) > sum) {
                return fib.get(i);
            }
            i++;
        }

    }

    public static void main(String[] args) {
        int[] ints = {5, 2, 1};
        System.out.println(ApproachingFibonacci(ints));

        int[] ints1 = {1, 20, 2, 5};
        System.out.println(ApproachingFibonacci(ints1));
    }

}
