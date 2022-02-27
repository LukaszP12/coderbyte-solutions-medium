package JavaRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountingMinutes2 {

    public static int CountingMinutes2(String str) {

        String pattern = "([0-9]+):([0-9]{2})(am|pm)-([0-9+]):([0-9]{2})(am|pm)$";
        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(str);
        System.out.println(m.matches());
        System.out.println(m.groupCount());
        System.out.println(m.group(0));
        int hour1 = Integer.parseInt(m.group(1));
        int minute1 = Integer.parseInt(m.group(2));
        int hour2 = Integer.parseInt(m.group(4));
        int minute2 = Integer.parseInt(m.group(5));

        if (hour1 == 12) {
            hour1 = 0;
        }
        if (hour2 == 12) {
            hour2 = 0;
        }
        if (m.group(3).equals("pm")) {
            hour1 += 12;
        }
        if (m.group(6).equals("pm")) {
            hour2 += 12;
        }
        int time1 = 60 * hour1 + minute1;
        int time2 = 60 * hour2 + minute2;
        int difference = time2 - time1;
        if (difference < 0) {
            difference += 1440;
        }
        return difference;
    }

    public static void main(String[] args) {
        System.out.println(CountingMinutes2("12:30pm-12:00am"));
    }

}
