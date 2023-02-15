import java.util.LinkedList;

public class StringReduction3 {

    public static int StringReduction3(String str) {
        StringBuilder temp;

        do {
            LinkedList<Character> list = new LinkedList<>();
            for (int i = 0; i < str.length(); i++) {
                list.add(str.charAt(i));
            }
            temp = new StringBuilder();
            while (!list.isEmpty()) {
                if (list.size() == 1) {
                    temp.append(list.remove());
                } else {
                    char a = list.getFirst();
                    char b = list.get(1);
                    if (a != b) {
                        if (a == 'a') {
                            if (b == 'b') {
                                temp.append('c');
                            }
                            if (b == 'c') {
                                temp.append('b');
                            }
                        } else if (a == 'b') {
                            if (b == 'a') {
                                temp.append('c');
                            }
                            if (b == 'c') {
                                temp.append('a');
                            }
                        }
                        if (a == 'c') {
                            if (b == 'b') {
                                temp.append('a');
                            }
                            if (b == 'a') {
                                temp.append('b');
                            }
                        }
                        list.remove();
                        list.remove();
                    } else {
                        temp.append(list.remove());
                    }
                }
            }
            str = temp.toString();
        } while (!checkCond(str));

        return str.length();
    }

    private static boolean checkCond(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
