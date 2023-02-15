import java.util.ArrayList;
import java.util.List;

public class PrimeTime_M {

    static boolean getPrimeTime(int num) {

        List<Integer> primes = new ArrayList<>();

        if (num == 2 || num == 3 || num == 5) {
            return true;
        }

        if (num % 2 == 0) {
            return false;
        } else if (num % 3 == 0) {
            return false;
        } else if (num % 5 == 0) {
            return false;
        }

        for (int i = 1; i <= num / 2; i++) {
            if (i % 2 != 0 || i % 3 != 0 || i % 5 != 0) {
                if (num % i == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(getPrimeTime(49));
    }
}
