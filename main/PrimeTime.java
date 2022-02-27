package JavaRegex;

import org.junit.Assert;

import java.util.Set;

public class PrimeTime {

    static String PrimeTime(int num) {

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return "false";
            }
        }
        return "true";
    }

    static boolean PrimeTime2(int num) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    static String PrimeTime3(int num) {
        if (num == 2) return "true";
        if (num % 2 == 0) return "false";
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) return "false";
        }

        return "true";
    }

    static String PrimeTime4(int num) {

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return "false";
            }
        }
        return "true";
    }

    private static Set<Integer> primes;

    static String PrimeTime5(int num) {

        if (num <= 1 || num > Math.pow(2, 16)) {
            return "false";
        }

        if (primes.contains(num)) {
            return "true";
        }

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return "false";
            }
        }

        primes.add(num);
        return "true";
    }

    static String PrimeTime6(int n) {
        if (n == 1) {
            return "false";
        }
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) {
                return "false";
            }
        }

        return "true";
    }


    public static void main(String[] args) {
        System.out.println(PrimeTime(19));
        System.out.println(PrimeTime(16));

        System.out.println(PrimeTime2(19));
        System.out.println(PrimeTime2(16));
    }

}
