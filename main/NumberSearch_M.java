public class NumberSearch_M {

    public static int searchNumber(String str) {
        // when then string does not contain numbers
        if (str.replaceAll("[^0-9]", "").isEmpty()) {
            return 0;
        }

        String[] split = str.replaceAll("[^0-9]", "").split("");
        double lettersLength = str.replaceAll("[^a-zA-Z]", "").length();

        double sum = 0;

        for (int i = 0; i < split.length; i++) {
            sum += Double.parseDouble("" + split[i]);
        }

        double v = 0;
        try {
            v = sum / lettersLength;
        } catch (ArithmeticException e) {
            throw new NumberFormatException("cannot divide by zero");
        }

        return (int) Math.round(v);
    }

    public static void main(String[] args) {
        String s = "H3ello9-9";
        System.out.println(searchNumber(s));

        String s1 = "One Number*1*";
        System.out.println(searchNumber(s1));

        String s3 = "3ko6";
        System.out.println(searchNumber(s3));

        String s4 = "comma2";
        System.out.println(searchNumber(s4));

        String s2 = "Two Houses";
        System.out.println(searchNumber(s2));
    }
}
