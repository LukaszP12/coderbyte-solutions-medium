package JavaRegex;

import org.junit.Assert;

public class ThreeFiveMultiples1 {

    public static int ThreeFiveMultiples(int num) {

        int sum = 0;
        for (int i = 1; i * 3 < num; i++) {
            sum += i * 3;
            if (i * 5 < num && (i * 5 % 3 != 0)) sum += i * 5;
        }

        return sum;
    }

    public static int ThreeFiveMultiples2(int num) {
        int sum = 0;
        for (int i = 0; i < num; i++) {
            sum += (i * 3 < num ? i * 3 : 0);
            sum += (i * 5 < num && i % 3 != 0 ? i * 5 : 0);
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(ThreeFiveMultiples(6));
        System.out.println(ThreeFiveMultiples(1));
        System.out.println(ThreeFiveMultiples(7));

        Assert.assertEquals(ThreeFiveMultiples(6), ThreeFiveMultiples2(6));
        Assert.assertEquals(ThreeFiveMultiples(1), ThreeFiveMultiples2(1));
        Assert.assertEquals(ThreeFiveMultiples(7), ThreeFiveMultiples2(7));

    }

}
