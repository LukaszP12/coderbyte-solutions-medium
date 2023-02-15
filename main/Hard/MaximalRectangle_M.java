package Hard;

import java.util.LinkedList;
import java.util.List;


public class MaximalRectangle_M {

    public static int MaximalRectangle(String[] strArr) {

        LinkedList<LinkedList<Integer>> matrix = new LinkedList<>();

        for (String s : strArr) {
            LinkedList<Integer> row = new LinkedList<>();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    row.add(i);
                }
            }
            matrix.add(row);
        }

        // row view
        int maxSquareRows = findMaxSquareRows(matrix);

        // column view
        int maxSquareColumns = findMaxSquareColumns(matrix);

        return Math.max(maxSquareRows, maxSquareColumns);
    }

    private static int findMaxSquareColumns(LinkedList<LinkedList<Integer>> matrix) {

        int maxField = 0;
        int length = matrix.size();

        LinkedList<LinkedList<Integer>> newMatrix = new LinkedList<LinkedList<Integer>>();
        for (int i = 0; i < length; i++) {
            LinkedList<Integer> column = new LinkedList<>();
            for (int j = 0; j < length; j++) {
                if (matrix.get(j).contains(i)) {
                    column.add(1);
                } else {
                    column.add(0);
                }
            }
            newMatrix.add(column);
        }

        return findMaxSquareRows(newMatrix);
    }

    private static int findMaxSquareRows(LinkedList<LinkedList<Integer>> matrix) {

        int maxField = 0;
        int length = matrix.size();

        for (int i = 0; i < length; i++) {
            int maxLength = 0;
            String lengthPattern = "";
            int index1 = 0;
            int index2 = length - 1;
            int counter = 0;

            for (int j = i; j < length; j++) {
                List<Integer> integers = matrix.get(j);
                String path = getLongestConsecutivePath(integers);
                String[] split = {"", ""};

                if (!path.isEmpty()) {
                    split = path.split(",");
                }

                if (Integer.parseInt(split[0]) < index1
                        && Integer.parseInt(split[1]) < index1) {
                    int area = (index2 - index1) * counter;
                    if (maxField < area) {
                        maxField = area;
                    }
                }

                if (Integer.parseInt(split[0]) > index2
                        && Integer.parseInt(split[1]) > index2) {
                    int area = (index2 - index1) * counter;
                    if (maxField < area) {
                        maxField = area;
                    }
                }


                if (Integer.parseInt(split[0]) >= index1
                        && Integer.parseInt(split[1]) <= index2) {
                    index1 = Integer.parseInt(split[0]);
                    index2 = Integer.parseInt(split[1]);
                    counter++;
                    lengthPattern = path;
                } else if (Integer.parseInt(split[0]) >= index1 || Integer.parseInt(split[1]) <= index2) {
                    counter++;
                }

                int area = (1 + index2 - index1) * counter;
                if (maxField < area) {
                    maxField = area;
                }
            }

            int area = (1 + index2 - index1) * counter;
            if (maxField < area) {
                maxField = area;
            }

        }

        return maxField;
    }

    private static String getLongestConsecutivePath(List<Integer> integers) {

        int counter = 1;
        String path = "";
        int max = 1;
        int prev = 0;
        int i = 0;

        for (; i < integers.size(); i++) {
            if (integers.get(prev) == integers.get(i) - 1) {
                counter++;
            } else {
                if (counter > max) {
                    max = counter;
                    path = prev + "," + i;
                }
                counter = 1;
            }

            prev = i;
        }

        if (counter > max) {
            path = integers.get(prev - (counter - 1)) + "," + integers.get(prev);
        }

        return path;
    }

    public static void main(String[] args) {
        String[] strings = {"1011", "0011", "0111", "1111"};
//        System.out.println(MaximalRectangle(strings));

        String[] strings1 = {"101", "111", "001"};
//        MaximalRectangle(strings1);

        String[] strings2 = {"10100", "10111", "11111", "10010"};
//        System.out.println(MaximalRectangle(strings2));
    }
}
