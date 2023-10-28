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

    public boolean balanced(Node root) {
        if (root == null) {
            return true;
        }

        if (Math.abs(node.left.heigh - node.right.heigh <= 1)) {
            return true;
        }

        return balanced(root.left) && balanced(root.right);
    }

    public void populateSorted(int[] nums, int s, int e) {
        if (s >= e) {
            return;
        }

        int m = (s + e) / 2;

        insert(root, nums[m]);
        populateSorted(nums, s, m);
        populateSorted(nums, m + 1, e);
    }

    public void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    public void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);

        inorder(root.left);
        inorder(root.right);
    }

    public void postorder(Node root) {
        if (root == null) {
            return;
        }
        
        inorder(root.left);
        inorder(root.right);

        System.out.println(root.val);
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
