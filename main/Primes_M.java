import java.util.HashSet;
import java.util.Set;

public class Primes_M {


    public static Boolean Primes(int num) {

        Set<Integer> primes = new HashSet<>();
        primes.add(2);
        primes.add(3);
        primes.add(5);

        for (int i = 1; i <= num; i++) {

            if (i % 2 != 0 && i % 3 != 0 && i % 5 != 0) {
                primes.add(i);
            }

            if (!isDivPrime(primes, i)) {
                primes.add(i);
            }

        }

        return primes.contains(num);
    }

    private static boolean isDivPrime(Set<Integer> primes, int i) {
        return primes.stream().filter(x -> i % x == 0).findAny().isPresent();
    }

    public static void main(String[] args) {
        System.out.println(Primes(4));
        System.out.println(Primes(1709));
    }
}
