public class SimplePassword_M {

    public static boolean getSimplePassword(String str) {

        if (str.length() > 7 && str.length() < 31) {
            if (str.matches(".*[0-9].*")) {
                if (str.matches(".*[.,!?:;+-,\\/*=].*")) {
                    if (!str.toLowerCase().matches(".*password.*")) {
                        if (str.matches(".*[A-Z].*")) {
                            return true;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }

            } else {
                return false;
            }
        } else {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "passWord123!!!!";
        System.out.println(getSimplePassword(s));

        String s1 = "turkey90AAA=";
        System.out.println(getSimplePassword(s1));

        String s2 = "123456A+";
        System.out.println(getSimplePassword(s2));
    }
}
