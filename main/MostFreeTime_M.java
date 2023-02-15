import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MostFreeTime_M {

    public static String getMostFreeTime(String[] times) {

        List<Integer> startings = new LinkedList<>();
        List<Integer> endings = new LinkedList<>();

        for (int i = 0; i < times.length; i++) {
            String[] splitTimes = times[i].split("-");
            startings.add(toMinutes(splitTimes[0]));
            endings.add(toMinutes(splitTimes[1]));
        }

        startings = startings.stream().sorted().collect(Collectors.toList());
        endings = endings.stream().sorted().collect(Collectors.toList());

        int maxTimeDiff = 0;

        for (int i = 0; i < endings.size() - 1; i++) {

            int timeDiff = startings.get(i + 1) - endings.get(i);

            if (timeDiff > 0 && maxTimeDiff < timeDiff) {
                maxTimeDiff = timeDiff;
            }

        }

        return toTimeFormat(maxTimeDiff);
    }

    private static String toTimeFormat(int maxTimeDiff) {
        int minutes = maxTimeDiff % 60;
        int hours = maxTimeDiff / 60;

        return fillZeros(hours) + ":" + fillZeros(minutes);
    }

    private static String fillZeros(int time) {
        int length = String.valueOf(time).length();

        if (length < 2) {
            if (time == 0) {
                return "00";
            } else {
                return "0" + time;
            }
        }

        return "" + time;
    }

    private static int toMinutes(String splitTime) {

        String amPM = splitTime.substring(splitTime.length() - 2);

        String[] split = splitTime.split(":");


        int hours = Integer.parseInt(split[0]);

        int minutes = Integer.parseInt(split[1].substring(0, 2));

        if (amPM.equals("AM") && hours == 12) {
            hours -= 12;
        }

        if (amPM.equals("PM")) {
            if (hours != 12) {
                hours += 12;
            }
        }

        return hours * 60 + minutes;
    }

    public static void main(String[] args) {
        String[] strings = {"12:15PM-02:00PM", "09:00AM-10:00AM", "10:30AM-12:00PM"};
        System.out.println(getMostFreeTime(strings));

        String[] strings1 = {"12:15PM-02:00PM", "09:00AM-12:11PM", "02:02PM-04:00PM"};
        System.out.println(getMostFreeTime(strings1));
    }
}
