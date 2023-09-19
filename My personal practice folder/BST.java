public class BST {
    
    // Node Definition
    public class Node {
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value) {
            this.value = value;
        }
    }


    // To get value of a node
    public int getvalue() {
        return value;
    }


    // Caller function for tree, not necessary
    public BST() {

    }

    // Initial root node
    private Node root;

    // To get height of a node
    public int height(Node node) {
        if (node == null) {
            return -1;
        }

        return node.height;
    }

    // To check empty tree
    public boolean isEmpty() {
        return root == null;
    }


    // To display
    public void display() {
        display(root, "Root Node: ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }

        System.out.println(details + node.value);

        display(node.left, "Left child of " + node.value + ": ");
        display(node.right, "Right child of " + node.value + ": ");
    }


    // Inserting Node
    public void insert(int value) {
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (node.value > value) {
            node.left = insert(value, node.left);
        }

        if (node.value < value) {
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.right), height(node.left)) + 1;

        return node;
    }


    // Checking balanced or not
    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }
    

    // Populate the tree
    public void populate(int[] nums) {
        for (int i : nums) {
            this.insert(i);
        }
    }


    // Populate for sorted array
    public void populateSorted(int[] nums) {
        populateSorted(nums, 0, nums.length - 1);
    }

    public void populateSorted(int[] nums,int s, int e) {
        if (s >= e) {
            return;
        }

        int m = s + (e - s) / 2;
        this.insert(nums[m]);

        populateSorted(nums, s, m);
        populateSorted(nums, m + 1, e);
    }


    // Preorder
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node + " ");
        preOrder(node.left);
        preOrder(node.right);
    }


    // InOrder
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node + " ");
        inOrder(node.right);
    }


    // PortOrder
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node + " ");
    }


    public static void main(String[] args) {
        BST tree = new BST();
        int[] nums = {4,5,3,2,8,7,9,6,1};
        // tree.populate(nums);
        tree.populateSorted(nums);
        tree.display();
    }
}
