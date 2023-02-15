import java.util.ArrayList;
import java.util.List;

public class PrimeMover_M {

    public static int getPrimeMover(int num) {

        List<Integer> primes = new ArrayList<>();

        int i = 2;

        while (true) {

            if (i == 2 || i == 3 || i == 5) {
                primes.add(i);
            } else if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0) {

            } else if (isDivPrimes(primes, i)) {

            } else {
                primes.add(i);
            }

            if (primes.size() == num) {
                return primes.get(primes.size() - 1);
            }

            i++;
        }

    }

    private static boolean isDivPrimes(List<Integer> primes, int i) {
        return primes.stream().anyMatch(p -> i % p == 0);
    }

    public static void main(String[] args) {
        System.out.println(getPrimeMover(1));
        System.out.println(getPrimeMover(2));
        System.out.println(getPrimeMover(9));
        System.out.println(getPrimeMover(16));
        System.out.println(getPrimeMover(100));
        System.out.println(getPrimeMover(400));
        System.out.println(getPrimeMover(565));
        System.out.println(getPrimeMover(312));
        System.out.println(getPrimeMover(567));
        System.out.println(getPrimeMover(90));
    }
}
