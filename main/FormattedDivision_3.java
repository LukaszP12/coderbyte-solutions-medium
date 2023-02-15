import java.text.DecimalFormat;

public class FormattedDivision_3 {

//    divide num1 by num2, and return the
//    result as a string with properly formatted commas
//    and 4 significant digits after the decimal place.

    public static String FormattedDivision(int num1, int num2) {
        double f = (double) num1 / num2;
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return "" + df.format(f);
    }

    public static String FormattedDivision2(int num1, int num2) {

        long v = Math.round(num1 * 1.0 / num2 * 10000);

        long i = v / 10000;
        long f = v % 10000;

        String si = String.valueOf(i);
        if (si.length() > 3) {
            StringBuffer sb = new StringBuffer();
            int count = 0;
            for (int ii = si.length() - 1; ii > 0; ii--) {
                sb.insert(0, si.charAt(ii));
                count++;
                if (count == 3 && ii > 0) {
                    sb.insert(0, ",");
                    count = 0;
                }
            }

            si = sb.toString();
        }

        return si + "." + String.valueOf(10000 + f).substring(1);
    }

    public static String FormattedDivision3(int num1, int num2) {

        double d = (double) num1 / (double) num2;

        return String.format("%1$,.4f", d);
    }


    public static void main(String[] args) {
//        System.out.println(FormattedDivision(2, 3));
        System.out.println(FormattedDivision2(2, 3));
        System.out.println(FormattedDivision3(2, 3));

//        System.out.println(FormattedDivision(10, 10));
        System.out.println(FormattedDivision2(10, 10));
        System.out.println(FormattedDivision3(10, 10));
    }

}
