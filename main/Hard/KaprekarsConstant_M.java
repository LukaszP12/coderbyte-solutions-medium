package Hard;

import java.util.Arrays;


public class KaprekarsConstant_M {

    static final int Kaprekars = 6174;

    static int result;

    public static int KaprekarsConstant(int num) {

        getNumber(num, 1);

        return result;
    }

    private static void getNumber(int num, int i) {

        int diff = getDescending(num) - getAscending(num);

        if (diff == Kaprekars) {
            result = i;
            return;
        }

        getNumber(diff, ++i);
    }

    private static int getAscending(int num) {

        char[] chars = String.valueOf(num).toCharArray();

        int[] numbers = new int[chars.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (chars[i] - 48);
        }

        int[] sortedInts = Arrays.stream(numbers).sorted().toArray();

        String result = "";
        for (int i = 0; i < sortedInts.length; i++) {
            result += "" + sortedInts[i];
        }


        return Integer.parseInt(result);
    }

    private static int getDescending(int num) {

        char[] chars = String.valueOf(num).toCharArray();

        int[] numbers = new int[chars.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (chars[i] - 48);
        }

        int[] sortedInts = Arrays.stream(numbers).sorted().toArray();

        String result = "";
        for (int i = sortedInts.length - 1; i >= 0; i--) {
            result += "" + sortedInts[i];
        }

        for (int i = result.length(); i < 4; i++) {
            result += "0";
        }

        return Integer.parseInt(result);
    }


    public static void main(String[] args) {
//        System.out.println(KaprekarsConstant(2111));
        System.out.println(KaprekarsConstant(9831));

    }

}
