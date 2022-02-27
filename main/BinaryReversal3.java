package JavaRegex;

public class BinaryReversal3 {

    private static String BinaryReversal(String str) {
        String binaryStr = Integer.toBinaryString(Integer.parseInt(str));
        String binaryStrReverse = "";
        while (!(binaryStr.length() == 8 || binaryStr.length() == 16
                || binaryStr.length() == 24 || binaryStr.length() == 32)) {
            binaryStr = 0 + binaryStr;
        }
        for (int i = binaryStr.length(); i > 0; i--) {
            binaryStrReverse += binaryStr.charAt(i - 1);
        }
        str = "" + Integer.parseInt(binaryStrReverse, 2);
        return str;
    }

    public static void main(String[] args) {
        System.out.println(BinaryReversal("213"));
    }

}
