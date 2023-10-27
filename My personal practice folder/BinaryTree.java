import java.util.Scanner;

public class BinaryTree {

    private Node root;

    public void populate(Scanner sc) {
        root = new Node(sc.nextInt());
        populate(sc, root);
    }

    public void populate(Scanner sc, Node root) {
        if (sc.hasNextInt()) {
            root.left = new Node(sc.nextInt());
            populate(sc, root.left);
        }
        if (sc.hasNextInt()) {
            root.right = new Node(sc.nextInt());
            populate(sc, root.right);
        }
    }

    public BinaryTree {

    }



    private static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }


    }

}
