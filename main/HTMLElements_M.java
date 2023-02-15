import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLElements_M {

    public static String getHTMLElements(String str) {

        List<String> openingBrackets = getAllOpeningBrackets(str);
        List<String> closingBrackets = getAllClosingBrackets(str);

        if (closingBrackets.isEmpty()) {
            return openingBrackets.get(0);
        }

        if (hasSameElements(openingBrackets, closingBrackets)) {
            return "true";
        }

        for (int i = 0; i < closingBrackets.size(); i++) {

            if (!openingBrackets.get(openingBrackets.size() - 1 - i).equals(closingBrackets.get(i).substring(1))) {
                return openingBrackets.get(openingBrackets.size() - 1 - i);
            }

        }

        return "true";
    }

    private static String removeMatchingAtBeginning(String str) {

        String s = "hello world<p></p><div><em><b></b></em></p>";
        int indexRemove = -1;

        for (int i = 0; i < str.length(); i++) {
            String elem = "";

            if (str.charAt(i) == '<') {
                int k = 0;
                while (str.charAt(i + k) != '>') {
                    k++;
                }
                elem = str.substring(i + 1, i + k + 1);
            }

            if (str.charAt(i) == '<' && str.charAt(i + 1) == '/') {
                if (str.substring(i + 2, i + 2 + elem.length()).equals(elem)) {
                    indexRemove = (i + 2 + elem.length() + 1);
                }
            }
        }

        if (indexRemove == -1) {
            return str;
        }

        return str.substring(indexRemove);
    }

    private static boolean hasSameElements(List<String> openingBrackets, List<String> closingBrackets) {

        for (int i = 0; i < openingBrackets.size(); i++) {
            if (!openingBrackets.get(i).equals(closingBrackets.get(i).substring(1))) {
                return false;
            }
        }

        return true;
    }

    private static List<String> getAllOpeningBrackets(String str) {
        List<String> elements = new LinkedList<>();

        String openingBracket = "(<[A-Za-z0-9]*>)";

        Matcher matcher = Pattern.compile(openingBracket).matcher(str);

        while (matcher.find()) {
            String s = matcher.group();
            elements.add(s.substring(1, s.length() - 1));
        }

        return elements;
    }

    private static List<String> getAllClosingBrackets(String str) {
        List<String> elements = new LinkedList<>();

        String closingBracket = "(</[A-Za-z0-9]*>)";

        Matcher matcher = Pattern.compile(closingBracket).matcher(str);

        while (matcher.find()) {
            String s = matcher.group();
            elements.add(s.substring(1, s.length() - 1));
        }

        return elements;
    }

    public static void main(String[] args) {
//        String s = "<div><div><b></b></div></p>";
//        System.out.println(getHTMLElements(s));
//
//        String s1 = "<div>abc</div><p><em><i>test test test</b></em></p>";
//        System.out.println(getHTMLElements(s1));

        String main = "hello world<p></p><div><em><b></b></em></p>";
        String s2 = "<div><em><b></b></em></p>";
//        System.out.println(getHTMLElements(s2));

        String s3 = "<div>";
//        System.out.println(getHTMLElements(s3));

        String s4 = "<p>hello</p><div></div>";
//        System.out.println(getHTMLElements(s4));
    }
}
