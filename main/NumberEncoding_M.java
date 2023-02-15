public class NumberEncoding_M {

    public static String getNumberEncoding(String str) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                result += "" + (str.charAt(i) - 'a' + 1);
            } else {
                result += "" + str.charAt(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "hello 45";
        System.out.println(getNumberEncoding(s));

        String s1 = "jaj-a";
        System.out.println(getNumberEncoding(s1));
    }
}
