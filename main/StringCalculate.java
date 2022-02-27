package JavaRegex;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculate {

    public static String StringCalculate(String str) {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");

        str.replaceAll("\\)\\(", "\\)*\\(");

        Pattern pattern = Pattern.compile("([0-9])\\(");
        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            str = matcher.replaceAll(matcher.group(1) + "*(");
        }

        return "";
    }

    public static void main(String[] args) {
        String s = "6*(4/2)+3*1";
        System.out.println(StringCalculate(s));

        String s1 = "100*2**4";
        System.out.println(StringCalculate(s1));
    }

}
