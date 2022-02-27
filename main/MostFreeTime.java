package JavaRegex;

import org.junit.Assert;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MostFreeTime {

    public static int getMinuteOfDay(String timeText) {
        int hour = Integer.parseInt(timeText.substring(0, 2));
        int minute = Integer.parseInt(timeText.substring(3, 5));
        if ((timeText.endsWith("PM")) && (hour != 12)) {
            hour += 12;
        } else if ((timeText.endsWith("AM")) && (hour == 12)) {
            hour -= 12;
        }
        minute += hour * 60;

        return minute;
    }

    public static String MostFreeTime(String[] strArr) {
        ArrayList<int[]> eventMinuteList = new ArrayList<>();
        int[] eventMinute, lastEventMinute;
        String[] eventTimeTextSet;
        for (int i = 0; i < strArr.length; i++) {
            eventTimeTextSet = strArr[i].split("-");
            eventMinute = new int[]{getMinuteOfDay(eventTimeTextSet[0]), getMinuteOfDay(eventTimeTextSet[1])};
            eventMinuteList.add(eventMinute);
        }

        Collections.sort(eventMinuteList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int mostFreeTime = 0;
        lastEventMinute = eventMinuteList.get(0);
        for (int i = 1; i < eventMinuteList.size(); i++) {
            eventMinute = eventMinuteList.get(i);
            mostFreeTime = Math.max(eventMinute[0] - lastEventMinute[1], mostFreeTime);
            lastEventMinute = eventMinute;
        }

        return String.format("%02d:%02d", (mostFreeTime / 60), (mostFreeTime % 60));
    }

    public static String MostFreeTime2(String[] strArr) {
        Map<LocalTime, LocalTime> map = new TreeMap<LocalTime, LocalTime>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mma");
        for (int i = 0; i < strArr.length; i++) {
            String[] startAndEndTimes = strArr[i].split("-");
            LocalTime start = LocalTime.parse(startAndEndTimes[0], dtf);
            LocalTime end = LocalTime.parse(startAndEndTimes[1], dtf);
            map.put(start, end);
        }
        Iterator<Map.Entry<LocalTime, LocalTime>> itr = map.entrySet().iterator();
        Map.Entry<LocalTime, LocalTime> entryPrev = itr.next();
        java.time.Duration maxDuration = Duration.ZERO;

        while (itr.hasNext()) {
            Map.Entry<LocalTime, LocalTime> entry = itr.next();
            Duration duration = Duration.between(entryPrev.getValue(), entry.getKey());
            if (duration.compareTo(maxDuration) > 0) {
                maxDuration = duration;
            }
            entryPrev = entry;

        }
        if (maxDuration.toHours() > 0) {
            return String.format("%02d:%02d", maxDuration.toHours(),
                    maxDuration.toMinutes() % (maxDuration.toHours() * 60));
        } else {
            return String.format("%02d:%02d", maxDuration.toHours(),
                    maxDuration.toMinutes());
        }
    }

    public static void main(String[] args) {
        String[] strings = {"12:15PM-02:00PM", "09:00AM-10:00AM", "10:30AM-12:00PM"};
        String[] strings1 = {"12:15PM-02:00PM", "09:00AM-12:11PM", "02:02PM-04:00PM"};

        System.out.println(MostFreeTime(strings));
        System.out.println(MostFreeTime(strings1));

        Assert.assertEquals(MostFreeTime(strings), MostFreeTime2(strings));
        Assert.assertEquals(MostFreeTime(strings1), MostFreeTime2(strings1));

        String name = "sonoo";
        System.out.println(String.format("name is %s", name));

        String format = String.format("value is %f", 32.33434);
        System.out.println(format);

        System.out.println(String.format("%d", 101));
        System.out.println(String.format("%s", "Amar Singh"));
        System.out.println(String.format("%f", 101.00));
        System.out.println(String.format("%x", 101));
        System.out.println(String.format("%c", 'c'));

        System.out.println(String.format("%d", 101));
        System.out.println(String.format("|%10d|", 101));
        System.out.println(String.format("|%-10d|", 101));
        System.out.println(String.format("|% d|", 101));
        System.out.println(String.format("|%010d|", 101));

    }

}
