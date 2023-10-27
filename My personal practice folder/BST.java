public class BST {

    private Node root;

    public BST() {

    }

    public int height(Node root) {
        if (root == null) {
            return -1;
        }

        return root.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void display() {
        display(root, "Root Node");
    }

    public void display(Node root, String details) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        display(root.left, details);
        display(root.right, details);
    }

    public Node insert(Node root, int val) {
        if (root == null) {
            Node node = new Node(val);
            return node;
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
            node.height = Math.max(node.left.heigh, node.right.height) + 1;
            return root;
        }
        
        root.right = insert(root.right, val);
        node.height = Math.max(node.left.heigh, node.right.height) + 1;
        return root;
    }

    public class Node {
        int val;
        Node left;
        Node right;
        int height;

        public Node(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }
    }
}
