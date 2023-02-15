import java.util.*;
import java.util.stream.Collectors;

public class TreeConstructor_M {

//     (i1,i2),where i1 represents a child node in a tree
//    and the second integer i2 signifies that it is the parent of i1.

    public static String getTreeConstructor(String[] strArr) {

        Map<String, String> child_parent = new HashMap<>();

        for (String s : strArr) {
            child_parent.put(s.substring(1, s.length() - 1).split(",")[0],
                    s.substring(1, s.length() - 1).split(",")[1]);
        }

        // check if every child has only one parent
        if (strArr.length != child_parent.size()) {
            return "false";
        }

        // check if every parent has 0 or 2 children
        Collection<String> values = child_parent.values();
        List<String> values_list = values.stream().sorted().collect(Collectors.toList());


        for (String value : values_list) {
            if (Collections.frequency(values_list, value) > 2) {
                return "false";
            }
        }

        return "true";
    }

    public static void main(String[] args) {
        String[] strings = {"(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)"};
        System.out.println(getTreeConstructor(strings));

        String[] strings1 = {"(1,2)", "(3,2)", "(2,12)", "(5,2)"};
        System.out.println(getTreeConstructor(strings1));
    }
}
