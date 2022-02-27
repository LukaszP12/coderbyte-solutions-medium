package JavaRegex;

public class MinWindowSubstring {

    public static String MinWindowSubstring(String[] strArr) {
        String stringN = strArr[0];
        String stringK = strArr[1];
        int min = Integer.MAX_VALUE;
        String result = "";
        for (int i = 0; i < stringN.length(); i++) {
            StringBuilder match = new StringBuilder(stringK);
            for (int j = i; j < stringN.length(); j++) {
                if (match.toString().contains(String.valueOf(stringN.charAt(j)))) {
                    int index = match.indexOf(String.valueOf(stringN.charAt(j)));
                    match.replace(index, index + 1, "");
                }
                if (match.length() == 0) {
                    if (j - i < min) {
                        min = j - i;
                        result = stringN.substring(i, j + 1);
                    }
                    break;
                }
            }
        }

        // How do we determine if a window is valid ?

        // How do we get all possible windows ?

        // How do we determine the minimum window ?


        // 1. Declare pointers for left and right, set them both to the first element
        // 2. Make a hash table of the chars in K & get the num of unique chars in K
        // 3. Save a variable to track the min window indices
        // 4. Move the right pointer across N until we have a valid window or reach the end by:
        //      a. Making a hash table to keep track of chars found in N
        //      b. Make a variable count to keep track of the num of chars found
        // 5. Once we have a valid window:
        //      a. Update the main window indices
        //      b. If the length of the window > length of K, move the left pointer
        //          i. If char removed is in K, decrease the count and repeat step 4
        //          ii. Update the min window indices
        // 6. Repeat 4-5 until left & right reaches the last element or the min
        // window's length == K.length

        // code goes here
        return result;
    }

    public static void main(String[] args) {
        String[] strings = {"ahffaksfajeeubsne", "jefaa"};

        System.out.print(MinWindowSubstring(strings));
    }

}
