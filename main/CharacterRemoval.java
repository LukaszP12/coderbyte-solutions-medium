package JavaRegex;

public class CharacterRemoval {

    private static int minChars = -1;

    // STRING ARRAY
    // the first element will be a sequence of characters representing a word
    // second element will be a long string of comma-separated words,
    // in alphabetical order, that represents a dictionary of some arbitrary length

    public static String CharacterRemoval(String[] strArr) {
        String[] words = strArr[1].split(",");
        String str = strArr[0];
        minChars = str.length();

        for (String word : words) {
            exploreMinRemoval(str, word);
        }

        return minChars == str.length() ? "-1" : String.valueOf(minChars);
    }

    private static void exploreMinRemoval(String str, String target) {
        int i = 0;
        int j = 0;
        int count = 0;

        while (i < str.length() && j < target.length()) {
            if (str.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
                count++;
            }
        }

        if (i <= str.length() && j == target.length()) {
            if (i != str.length()) {
                count = count + (str.length() - i);
            }
            minChars = Math.min(minChars, count);
        }
    }

    public static void main(String[] args) {
        String[] strings = {"baseball", "a,all,b,ball,bas,base,cat,code,d,e,quit,z"};
        System.out.println(CharacterRemoval(strings));

        String[] strings1 = {"apbpleeeef", "a,ab,abc,abcg,b,c,dog,e,efd,zzzz"};
        System.out.println(CharacterRemoval(strings1));
    }
}
