import java.util.ArrayList;
import java.util.List;

public class SwapII_M {

    public static String SwapII(String str) {

        String result = "";

        List<Integer> numberIndexes = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);

            if (Character.isLowerCase(charAt)) {
                result += "" + Character.toUpperCase(charAt);
            } else if (Character.isUpperCase(charAt)) {
                result += "" + Character.toLowerCase(charAt);
            } else if (Character.isDigit(charAt)) {
                numberIndexes.add(i);
                result += "" + charAt;
            } else {
                result += "" + charAt;
            }

            if (numberIndexes.size() == 2) {
                int index1 = numberIndexes.get(0);
                int index2 = numberIndexes.get(1);

                String substring = result.substring(index1 + 1, index2);
                boolean containsLetters = substring.matches(".*[a-zA-Z]+.*");
                boolean containsSpace = substring.matches(".*[\\s].*");
                if (!containsLetters || containsSpace) {
                    numberIndexes = new ArrayList<>();
                }
            }

            if (numberIndexes.size() == 2) {
                int index1 = numberIndexes.get(0);
                int index2 = numberIndexes.get(1);

                result = result.substring(0, index1) + result.charAt(index2) + result.substring(index1 + 1, index2) +
                        result.charAt(index1) + result.substring(index2 + 1);

                numberIndexes = new ArrayList<>();
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        String s = "Hello -5LOL6";
//        System.out.println(SwapII(s));

        String s1 = "2S 6 du5d4e";
        System.out.println(SwapII(s1));

//        String s2 = "123gg))((";
//        System.out.println(SwapII(s2));

//        String s3 = "6coderbyte5";
//        System.out.println(SwapII(s3));
    }
}
