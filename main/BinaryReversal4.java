package JavaRegex;

public class BinaryReversal4 {

    private static String BinaryReversal(String str) {
        String binaryStr = Integer.toBinaryString(Integer.valueOf(str));
        int numOfZerosToPrepend = binaryStr.length() % 8 > 0 ? 8 - (binaryStr.length() % 8) : 0;
        for (int i = 0; i < numOfZerosToPrepend; i++) {
            binaryStr = "0" + binaryStr;
        }
        StringBuilder reversedBinary = new StringBuilder();
        reversedBinary.append(binaryStr);
        reversedBinary = reversedBinary.reverse();
        return String.valueOf(Integer.parseInt(reversedBinary.toString(), 2));
    }

    public static void main(String[] args) {
        System.out.println(BinaryReversal("213"));
    }
}
