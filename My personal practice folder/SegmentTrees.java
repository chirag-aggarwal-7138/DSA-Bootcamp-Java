public class SegmentTrees {
    
    Node root;

    public SegmentTrees(int[] nums) {
        this.root = constructTree(nums, 0, nums.length - 1);
    }

    private Node constructTree(int[] nums, int start, int end){
        if (start == end) {
            Node leaf = new Node(start, end);
            leaf.data = nums[start];
            return leaf;
        }

        Node node = new node(start, end);

        int mid = (start + end) / 2;

        node.left = constructTree(nums, start, mid);
        node.right = constructTree(nums, mid + 1, end);

        node.data = node.left.data + node.right.data;
        return node;
    }

    public void display(Node node) {
        String str = "";

        if (node.left != null) {
            str = str + node.left.startInterval + " " + node.left.endInterval + " " + node.left.data;
        } else {
            str += "No left child";
        }

        str += node.startInterval + " " + node.endInterval + " " + node.data;

        if (node.right != null) {
            System.out.println(node.right.startInterval + " " + node.right.endInterval + " " + node.right.data);
        } else {
            System.out.println("No right child");
        }

        System.out.println(str);

        if (node.left != null) {
            display(node.left);
        }
       
        if (node.right != null) {
            display(node.right);
        }
    }

    public int query(Node root, int qstart, int qend) {
        if (root.startInterval >= qstart && root.endInterval <= qend) {
            return root.data;
        }

        if (root.startInterval > qend || root.endInterval < qstart) {
            return 0;
        }

        return query(root.left, qstart, qend) + query(root.right, qstart, qend);
    }

    public int update(Node node, int index, int val) {
        if (index >= node.startInterval && index <= node.endInterval) {
            if (index == node.startInterval && index == node.endInterval) {
                node.data = val;
                return node.data;
            } else {
                int left = update(node.left, index, val);
                int right = update(node.right, index, val);

                node.data = left + right;
                return node.data;
            }
        }

        return node.data;
    }

    private class Node {
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }

    }
}
