package JavaRegex;

public class CountingMinutes4 {

    private static String CountingMinutes(String str) {
        String[] times = str.split("-");

        int result = minutes(times[1]) - minutes(times[0]);

        return "" + (result < 0 ? result + (24 * 60) : result);
    }

    private static int minutes(String time) {
        // Extract AM/PM from the end of the time
        String amPm = time.substring(time.length() - 2);

        String[] hrMin = time.substring(0, time.length() - 2).split(":");

        // convert the hours to minutes (integer)
        int hr = amPm.equals("am") ? hrMin[0].equals("12") ? 0 : Integer.valueOf(hrMin[0]) : hrMin[0].equals("12") ? 12 : Integer.valueOf(hrMin[0] + 12) * 60;

        // convert the minutes to an integer
        int min = Integer.valueOf(hrMin[1]);

        // return the total number elapsed minutes for the time since midnight
        return hr + min;
    }

    public static void main(String[] args) {
        String time = "12:30pm-12:00am";
        String time1 = "1:23am-1:08am";

        String s = CountingMinutes(time);
        System.out.println(s);
        String s1 = CountingMinutes(time1);
        System.out.println(s1);
    }
}
