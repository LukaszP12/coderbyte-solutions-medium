package JavaRegex;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CountingMinutes1 {

    public static String CountingMinutes1(String str) {
        String[] fullTime = str.split("-");
        DateFormat df = new SimpleDateFormat("h:mma");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = df.parse(fullTime[0]);
            date1 = df.parse(fullTime[1]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long differenceInMins = (Math.abs(date1.getTime() - date2.getTime()) / 1000 / 60);

        if (date2.before(date1)) {
            differenceInMins = 1440 - ((date1.getTime() - date2.getTime()) / 1000 / 60);
        }
        return Long.toString(differenceInMins);
    }


    public static void main(String[] args) {
        System.out.println(CountingMinutes1("12:30pm-12:00am"));
    }

}
