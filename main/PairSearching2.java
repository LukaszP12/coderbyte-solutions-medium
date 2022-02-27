package JavaRegex;

public class PairSearching2 {

    public static class Node {
        private Node parent = null;
        private int num;

        public Node(int num, Node parent) {
            this.num = num;
            this.parent = parent;
        }

        public Node getParent() {
            return this.parent;
        }

        public int getNum() {
            return num;
        }

    }

    public static boolean hasPair(Node node) {

        String strVal = "";

        Node t = node;
        while (t != null) {
            strVal = t.getNum() + strVal;
            t = t.getParent();
        }

        return false;
    }

}
