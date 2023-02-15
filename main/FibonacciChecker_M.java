import java.util.ArrayList;
import java.util.List;

public class FibonacciChecker_M {

    public static String getFibonacciChecker(int num) {

        List<Integer> fibo = new ArrayList<>();
        fibo.add(0);
        fibo.add(1);

        int i = 1;

        while (true) {
            fibo.add(fibo.get(i) + fibo.get(i - 1));
            i++;

            if (fibo.get(i) >= num) {
                break;
            }
        }

        return fibo.contains(num) ? "yes" : "no";
    }

    public static void main(String[] args) {
//        System.out.println(getFibonacciChecker(34));
        System.out.println(getFibonacciChecker(54));
    }
}
