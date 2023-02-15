package Hard;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PatternChaser_M {

    public static String PatternChaser(String str) {

        List<String> patterns = getAllPattern(str);
        patterns = patterns.stream().sorted().collect(Collectors.toList());

        List<String> duplicates = findDuplicates(patterns);

        return duplicates.isEmpty() ? "no null" : "yes " + duplicates.get(duplicates.size() - 1);
    }

    private static List<String> findDuplicates(List<String> patterns) {

        List<String> duplicates = new LinkedList<>();

        int longest = 1;

        String previous = patterns.get(0);
        for (int i = 1; i < patterns.size(); i++) {

            String s = patterns.get(i);

            if (s.equals(previous) && s.length() > longest) {
                duplicates.add(s);
                longest = s.length();
            }
            previous = s;
        }


        return duplicates;
    }

    private static List<String> getAllPattern(String str) {
        List<String> list = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {

            for (int j = i; j <= str.length(); j++) {
                String pattern = str.substring(i, j);
                list.add(pattern);
            }

        }

        return list;
    }

    public static void main(String[] args) {
//        System.out.println(PatternChaser("da2kr32a2"));
        System.out.println(PatternChaser("sskfssbbb9bbb"));
    }
}
