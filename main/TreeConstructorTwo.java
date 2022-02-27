package JavaRegex;

import java.util.ArrayList;
import java.util.Hashtable;

public class TreeConstructorTwo {

//    determine if an array of integer pairs can form a binary tree properly.

    public static boolean TreeConstructorTwo(String[] strArr) {
        if (strArr.length == 0) return true;
        Hashtable<String, ArrayList<String>> connections = new Hashtable<>();
        Hashtable<String, String> children = new Hashtable<>();
        ArrayList<String> allChild = new ArrayList<String>();
        for (String i : strArr) { //check # of children at each parent & number of parents for each child
            String[] vals = i.replace("(", "").replace(")", "").split(",");
            String child = vals[0];
            String parent = vals[1];
            if (children.containsKey(child)) return false;
            if (connections.containsKey(parent)) {
                ArrayList<String> newList = connections.get(parent);
                newList.add(child);
                connections.put(parent, newList);
                if (connections.get(parent).size() > 2) return false;
            } else {
                ArrayList<String> newList = new ArrayList<String>();
                newList.add(child);
                connections.put(parent, newList);
            }
            children.put(child, parent);
            allChild.add(child);
        }
        String root = allChild.get(0);
        for (String i : allChild) {
            String par = children.get(i);
            int counter = 0;
            while (children.containsKey(par)) {
                par = children.get(par);
                counter += 1;
                if (counter > strArr.length) return false;
            }
            if (root != allChild.get(0) && Integer.valueOf(par) != Integer.valueOf(root)) return false;
            root = par;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strings = {"(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)"};
        String[] strings1 = {"(1,2)", "(1,3)"};
    }
}
