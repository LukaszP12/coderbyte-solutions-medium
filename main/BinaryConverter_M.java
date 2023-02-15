public class BinaryConverter_M {

    public static int getBinaryConverter(String str) {

        int sum = 0;
        int j = 0;

        for (int i = str.length() - 1; i >= 0; i--) {
            if (i == str.length() - 1 && str.charAt(i) == '1') {
                sum += 1;
            } else {
                if (str.charAt(i) == '1') {
                    sum += Math.pow(2,j);
                }
            }

            j++;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getBinaryConverter("100101"));
        System.out.println(getBinaryConverter("011"));
    }
}
