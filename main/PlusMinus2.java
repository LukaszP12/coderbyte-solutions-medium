package JavaRegex;

public class PlusMinus2 {

    private static StringBuilder res = new StringBuilder();
    private static int maxNumMinus = -1;

    private static String PlusMinus(int num) {
        populate(num, 0, new StringBuilder(), 0);

        return res.length() == 0 ? "not possible" : res.toString();
    }

    private static void populate(int num, int sum, StringBuilder sb, int numMinus) {
        if (num == 0) {
            if (sum == 0 && numMinus > maxNumMinus) {
                res = sb;
            }
            return;
        }

        int digit = num % 10;

        if (num / 10 == 0) {
            populate(0, sum + digit, new StringBuilder(sb), numMinus);
            return;
        }

        StringBuilder copy1 = new StringBuilder(sb);
        StringBuilder copy2 = new StringBuilder(sb);

        // plus sign
        populate(num / 10, sum + digit, copy1.insert(0, "+"), numMinus);

        // minus sign
        populate(num / 10, sum - digit, copy2.insert(0, "-"), numMinus + 1);

    }

    public static void main(String[] args) {
        System.out.println(PlusMinus(199));
        System.out.println(PlusMinus(26712));
    }
}
