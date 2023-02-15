import java.util.Stack;

public class BracketMatcher_M {

    public static int isBracketMatched(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') {
                stack.add(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return 0;
                }
                stack.pop();
            }

        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        String s = "(coder)(byte))";
        System.out.println(isBracketMatched(s));

        String s1 = "(c(oder)) b(yte)";
        System.out.println(isBracketMatched(s1));
    }
}
