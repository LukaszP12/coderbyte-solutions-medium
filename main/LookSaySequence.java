package JavaRegex;

public class LookSaySequence {

    public static String LookSaySequence(int num) {
        char[] sequence = ("" + num).toCharArray();
        String result = "";
        int count = 0;
        char lastChar = '\0';

        for (char a : sequence) {
            if (a == lastChar) {
                count++;
            } else {
                if (lastChar != '\0') {
                    result += count;
                    result += Character.toString(lastChar);
                }
                lastChar = a;
                count = 1;
            }
        }
        result += count;
        result += Character.toString(lastChar);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(LookSaySequence(1211));
        System.out.println(LookSaySequence(2466));
    }
}
