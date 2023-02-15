import java.util.*;
import java.util.stream.Collectors;


public class PrimeChecker_M {

    public static int getPrimeChecker(int num) {

        char[] charArray = String.valueOf(num).toCharArray();
        List<Character> list = new LinkedList<>();

        if (allDigitsSame(num)) {
            if (isPrime(num)) {
                return 1;
            } else {
                return 0;
            }
        }

        for (char c : charArray) {
            list.add(c);
        }

        Set<Integer> combinations = getCombinations(list);

        return combinations.stream().filter(x -> isPrime(x)).findAny().isPresent() ? 1 : 0;
    }

    private static boolean allDigitsSame(int num) {
        int i = String.valueOf(num).charAt(0) - 48;

        return (String.valueOf(num).replaceAll("" + i, "").length() == 0) ? true : false;
    }

    private static boolean isPrime(Integer num) {

        List<Integer> primes = new LinkedList<>();
        primes.add(2);
        primes.add(3);
        primes.add(5);

        for (int i = 2; i <= num; i++) {
            boolean divByPrime = primes.stream().filter(x -> num % x == 0).findAny().isPresent();

            if (num % 2 != 0 && num % 3 != 0 && num % 5 != 0 && !divByPrime) {
                primes.add(i);
            }
        }

        return primes.contains(num);
    }

    private static Set<Integer> getCombinations(List<Character> list) {

        Set<Integer> combinations = new HashSet<>();

        int factorialSize = getFactorialSize(list.size());
        int repeated = getRepeated(list);

        while (combinations.size() < (factorialSize / repeated)) {
            Collections.shuffle(list);

            String number = "";
            for (int i = 0; i < list.size(); i++) {
                number += "" + list.get(i);
            }

            int integer = Integer.valueOf(trimLeadingZeros(number));
            combinations.add(integer);
        }

        return combinations;
    }

    private static int getRepeated(List<Character> list) {
        List<Character> sorted = list.stream().sorted().collect(Collectors.toList());

        int repeated = 1;
        char previous = ' ';

        for (Character c : sorted) {
            if (c == previous) {
                repeated++;
            } else {
                previous = c;
            }
        }

        return repeated;
    }

    private static String trimLeadingZeros(String source) {
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            if (c != '0') {
                return source.substring(i);
            }
        }

        return "";
    }

    private static int getFactorialSize(int num) {

        int factorial = 1;

        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }

        return factorial;
    }

    public static void main(String[] args) {
//        System.out.println(getPrimeChecker(98));
//        System.out.println(getPrimeChecker(598));
//        System.out.println(getPrimeChecker(11));

//        System.out.println(getPrimeChecker(772));
//        System.out.println(getPrimeChecker(100));
    }
}
