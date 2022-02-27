package JavaRegex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test1 {

    @Test
    public void test() {
        Pattern pattern = Pattern.compile("regex");
        Matcher matcher = pattern.matcher("Badany ciąg znaków");

    }

}
