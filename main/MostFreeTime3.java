package JavaRegex;

import java.sql.Time;
import java.util.Arrays;

public class MostFreeTime3 {

    public static class TimeWindow {
        int start;
        int end;

        TimeWindow(String str) {
            String strs[] = str.split("-");
            for (int i = 0; i < 2; i++) {
                String time = strs[i];
                boolean isPM = time.indexOf("PM") > 0;
                time = time.substring(0, time.length() - 2);
                String[] times = time.split(":");
                int h = Integer.valueOf(times[0]);
                int m = Integer.valueOf(times[1]);
                int v = h * 60 + m;

                if (isPM && h < 12) {
                    v += 12 * 60;
                }

                if (i == 0) {
                    this.start = v;
                } else {
                    this.end = v;
                }
            }
        }

    }

    private static String MostFreeTime(String[] strArr) {
        TimeWindow[] arr = new TimeWindow[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = new TimeWindow(strArr[i]);
        }

        Arrays.sort(arr, (a, b) -> a.start - a.end);
        int max = 0;

        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i].start - arr[i - 1].end);
        }

        int h = max / 60;
        int m = max % 60;
        StringBuffer sb = new StringBuffer();
        if (h < 10) sb.append('0');
        sb.append(h).append(':');
        if (m < 10) sb.append('0');
        sb.append(m);

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"12:15PM-02:00PM", "09:00AM-10:00AM", "10:30AM-12:00PM"};
        String[] strings1 = {"12:15PM-02:00PM", "09:00AM-12:11PM", "02:02PM-04:00PM"};

        System.out.println(MostFreeTime(strings));
        System.out.println(MostFreeTime(strings1));
    }

}
