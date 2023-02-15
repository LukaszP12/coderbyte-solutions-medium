import java.util.Stack;

public class PreorderTraversal_2 {

    public static String PreorderTraversal(String[] strArr) {

        Stack<Integer> stack = new Stack<Integer>();
        stack.add( 0 );
        StringBuilder sb = new StringBuilder();
        while( stack.isEmpty() == false ) {
            int idx = stack.pop();
            sb.append(strArr[idx]);
            if( (2*idx) + 2 < strArr.length && !strArr[(2*idx) + 2].equals("#") )
                stack.add((2*idx)+2);
            if( (2*idx) + 1 < strArr.length && !strArr[(2*idx) + 1].equals("#") )
                stack.add((2*idx)+1);
            if( stack.isEmpty() == false )
                sb.append(" ");
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        String[] strings = {"4", "1", "5", "2", "#", "#", "#"};
//        PreorderTraversal(strings);

        String[] strings1 = {"2", "6", "#"};
//        PreorderTraversal(strings1);

        String[] strings2 = {"5", "2", "6", "1", "9", "#", "8", "#", "#", "#", "#", "4", "#"};
        System.out.println(PreorderTraversal(strings2));
    }
}
