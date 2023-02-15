import java.util.Stack;

public class MultipleBrackets_M {

    public static String checkMultipleBrackets(String str) {

        Stack<Character> brackets = new Stack<>();

        int counter = 0;

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

            if (c == '(') {
                brackets.add('(');
                continue;
            }

            if (c == '[') {
                brackets.add('[');
                continue;
            }

            if (c == ')' && brackets.isEmpty()) {
                return "0";
            }

            if (c == ']' && brackets.isEmpty()) {
                return "0";
            }

            if (c == ')') {
                if (brackets.peek() == '(') {
                    brackets.pop();
                    counter++;
                    continue;
                } else {
                    return "0";
                }
            }

            if (c == ']') {
                if (brackets.peek() == '[') {
                    brackets.pop();
                    counter++;
                } else {
                    return "0";
                }
            }

        }

        if (counter == 0 || !brackets.isEmpty()) {
            return "0";
        }

        return 1 + " " + counter;
    }

    public static void main(String[] args) {
//        String s = "(coder)[byte)]";
//        System.out.println(checkMultipleBrackets(s));

//        String s1 = "(c([od]er)) b(yt[e])";
//        System.out.println(checkMultipleBrackets(s1));

//        String s2 = "coder(b)(y)(t)([e))";
//        System.out.println(checkMultipleBrackets(s2));

        String s3 = "()code[rb]yte() yes()[ss][[";
        System.out.println(checkMultipleBrackets(s3));
    }
}
