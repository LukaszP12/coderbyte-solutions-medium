package Hard;

import java.math.BigInteger;

public class SquareFigures_M {

    public static int SquareFigures(int num) {

        return (int) getNumberSquaredEquals(num);
    }

    public static long getNumberSquaredEquals(int num) {

        long i = 0;
        long squared = 0;

        while (num > String.valueOf(squared).length()) {
            squared = (long) Math.pow(i, 2);
            if (num == String.valueOf(squared).length()) {
                break;
            }

            i++;
        }

        return i;
    }

    public static void main(String[] args) {
//        System.out.println(SquareFigures(2));
//        System.out.println(SquareFigures(1));

//        System.out.println(SquareFigures(3));
        System.out.println(SquareFigures(11));
    }

}
