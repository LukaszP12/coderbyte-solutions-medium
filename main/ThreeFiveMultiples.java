package JavaRegex;

public class ThreeFiveMultiples {

//    return the sum of all the multiples of 3 and 5

    public static int ThreeFiveMultiples(int num) {
        int sum = 0;

        if (num < 3) {
            return sum;
        }

        for (int i = 3; i < num; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }

        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(ThreeFiveMultiples(6));
        System.out.println(ThreeFiveMultiples(1));
        System.out.println(ThreeFiveMultiples(7));
    }

}
