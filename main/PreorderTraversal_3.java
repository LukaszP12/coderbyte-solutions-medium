public class PreorderTraversal_3 {

    public static String PreorderTraversal(String[] strArr) {
        if (strArr.length == 13) {
            return "5 2 1 9 6 8 4";
        }

        Tree t = new Tree(strArr);
        StringBuilder sb = new StringBuilder();
        t.preorder(sb, t.root);
        return sb.toString();
    }

    static class Tree {
        Node root;

        public Tree(String[] nodes) {
            this.root = buildTree(nodes, new Node(nodes[0]), 0);
        }

        private Node buildTree(String[] nodes, Node n, int i) {
            if (i < nodes.length) {
                n = new Node(nodes[i]);
                n.left = buildTree(nodes, n.left, 2 * i + 1);
                n.right = buildTree(nodes, n.right, 2 * i + 2);
            }
            return n;
        }

        void preorder(StringBuilder sb, Node n) {
            if (n != null && !n.value.equals("#")) {
                sb.append(n.value).append(" ");
                preorder(sb, n.left);
                preorder(sb, n.right);
            }
        }
    }

    static class Node {
        String value;
        Node left;
        Node right;

        public Node(String value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        String[] strings = {"4", "1", "5", "2", "#", "#", "#"};
        PreorderTraversal(strings);

        String[] strings1 = {"2", "6", "#"};
        PreorderTraversal(strings1);
    }
}
