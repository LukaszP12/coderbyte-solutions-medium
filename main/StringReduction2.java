public class StringReduction2 {

    public static int StringReduction2(String str) {
        boolean swap = true;
        String[] pairs = {"ab", "ac", "ba", "bc", "ca", "cb"};
        String[] replacements = {"c", "b", "c", "a", "b", "a"};
        while (swap) {
            swap = false;
            int min = -1;
            for (int i = 0; i < pairs.length; i++) {
                if ((min == -1 && str.indexOf(pairs[i]) != -1) || (str.indexOf(pairs[i]) != -1 && str.indexOf(pairs[i]) < str.indexOf(pairs[min]))) {
                    min = i;
                }
            }
            if (min != -1 && str.indexOf(pairs[min]) != -1) {
                swap = true;
                str = str.replaceFirst(pairs[min], replacements[min]);
            }
        }

        return str.length();
    }

    public static void main(String[] args) {
        String abcabc = "abcabc";
        System.out.println(StringReduction2(abcabc));

        System.out.println(StringReduction2("cccc"));
    }
}
