public class SegmentTrees {
    

    // Node definition
    private static class Node {
        int data;
        int startInterval;
        int endInterval;
        Node right;
        Node left;

        public Node(int startInterval, int endInterval) {
        this.startInterval = startInterval;
        this.endInterval = endInterval;
        }
    }


    // Initial root
    Node root;

    // SegmentTree class constructor
    public SegmentTrees(int[] nums) {
        // create a tree using this array
        this.root = constructTree(nums, 0, nums.length - 1);
    }


    // construct tree
    private Node constructTree(int[] nums, int start, int end) {
        if (start == end) {
            // u r at leaf node
            Node lead = new Node(start, end);
            lead.data = nums[start];
            return leaf;
        }

        // create an node with index u r at
        Node node = new Node(start, end);

        int mid = (start + end) / 2;

        node.left = this.constructTree(nums, start, mid);
        node.right = this.constructTree(nums, mid + 1, end);

        node.data = node.left.data + node.right.data;
        return node;
    }


    // Display
    public void display() {
        display(this.root);
    }

    private void display(Node node) {
        String str = "";


        // for left node
        if (node.left != null) {
            str = str + node.left.startInterval + " - " + node.left.endInterval + " : " + node.left.data;
        } else {
            str = str + "No left child";
        }

        // for current node
        str = str + node.startInterval + " - " + node.endInterval + " : " + node.data;

        if (node.right != null) {
            str = str + node.right.startInterval + " - " + node.right.endInterval + " : " + node.right.data;
        } else {
            str = str + "No right child";
        }

        System.out.println(str);

        // call recursion
        if (node.left != null) {
            display(node.left);
        }

        if (node.right != null) {
            display(node.right);
        }
    }

    // Query
    public int query(int qsi, int qei) {
        return this.query(this.root, qsi, qei);
    }

    private int query(Node node, int qsi, int qei) {
        if (node.startInterval >= qsi && node.endInterval <= qei) {
            // query is completely lying inside query
            return node.data;
        } else if (node.startInterval > qei || node.endInterval < qsi) {
            // Query is completely outside
            return 0;
        } else {
            // overlapping
            return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
        }
    }


    // Update
    public void update(int index, int value) {
        this.root.data = update(this.root,index, value);
    }

    private int update(Node node, int index, int value) {
        if (index >= node.startInterval && index <= node.endInterval) {
            if (index == node.startInterval && index == node.endInterval) {
                node.data = value;
                return node.data;
            } else {
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);
                node.data = leftAns + rightAns;
                return node.data;
            }
        }
        return node.data;
    }
}
