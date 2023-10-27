/**
 * This class represents a Circular Linked List (CLL) data structure.
 * It has a private inner class Node which represents a node in the CLL.
 * The CLL has two pointers, head and tail, which point to the first and last nodes respectively.
 * The class has methods to insert a node, delete a node and display the CLL.
 */
/**
 * This class represents a Circular Linked List (CLL) data structure.
 */
public class CLL {

    private Node head; // The head of the CLL
    private Node tail; // The tail of the CLL

    /**
     * Constructor for the CLL class.
     * Initializes the head and tail to null.
     */
    public CLL() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Inserts a new node with the given value to the CLL.
     * @param val The value to be inserted.
     */
    public void insert(int val) {
        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = newNode;
            return;
        }

        tail.next = newNode;
        newNode.next = head;
        tail = node;
    }

    /**
     * Displays the values of all nodes in the CLL.
     */
    public void display() {
        if (head = null) {
            System.out.println("Empty list");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("HEAD");
    }

    /**
     * Deletes the node with the given value from the CLL.
     * @param val The value to be deleted.
     */
    public void delete(int val) {
        if (head == null) {
            System.out.println("Cannot delete from an empty list");
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        if (node.val == val) {
            head = head.next;
            tail.next = head;
            return;
        }

        Node temp = head;
        do {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
                return;
            } else {
                temp = temp.next;
            }
        } while (temp != head);
    }

    /**
     * This class represents a node in the CLL.
     */
    private class Node {
        int val; // The value of the node
        Node next; // The next node in the CLL

        /**
         * Constructor for the Node class.
         * @param val The value of the node.
         */
        private Node(int val) {
            this.val = val;
        }

        /**
         * Constructor for the Node class.
         * @param val The value of the node.
         * @param next The next node in the CLL.
         */
        private Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

}
