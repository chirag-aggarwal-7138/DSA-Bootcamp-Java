/**
 * A class that represents a singly linked list data structure.
 */
/**
 * This class represents a singly linked list data structure.
 * It provides methods to insert, delete and display nodes in the list.
 */
/**
 * A class that represents a singly linked list.
 */
public class LL {

    private Node head; // the first node in the list
    private Node tail; // the last node in the list

    private int size; // the number of nodes in the list

    /**
     * Inserts a new node with the given value at the beginning of the list.
     * 
     * @param val the value to be inserted
     */
    public void insertFirst(int val) {

        Node newNode = new Node(val); // create a new node with the given value
        newNode.next = head; // set the next pointer of the new node to the current head
        head = newNode; // set the new node as the new head of the list

        if (tail == null) { // if the list was empty before the insertion
            tail = newNode; // set the new node as the tail of the list
        }

        size++; // increment the size of the list
    }

    /**
     * Inserts a new node with the given value at the end of the list.
     * 
     * @param val the value to be inserted
     */
    public void insertLast(int val) {

        Node newNode = new Node(val); // create a new node with the given value

        if (tail != null) { // if the list is not empty
            tail.next = newNode; // set the next pointer of the current tail to the new node
            tail = newNode; // set the new node as the new tail of the list
            size++; // increment the size of the list
        } else { // if the list is empty
            insertFirst(val); // insert the new node at the beginning of the list
        }
    }

    /**
     * Inserts a new node with the given value at the specified index in the list.
     * 
     * @param val   the value to be inserted
     * @param index the index at which the value should be inserted
     */
    public void insertAtIndex(int val, int index) {

        if (index == 0) { // if the new node should be inserted at the beginning of the list
            insertFirst(val); // insert the new node at the beginning of the list
            return;
        }

        if (index == size) { // if the new node should be inserted at the end of the list
            insertLast(val); // insert the new node at the end of the list
            return;
        }

        Node newnNode = new Node(val); // create a new node with the given value
        Node temp = head; // start at the head of the list
        int i = 0;
        while (i != index - 1) { // traverse the list until the node before the insertion point is reached
            temp = temp.next;
            i++;
        }

        newnNode.next = temp.next; // set the next pointer of the new node to the node at the insertion point
        temp.next = newnNode; // set the next pointer of the node before the insertion point to the new node
        size++; // increment the size of the list
    }

    /**
     * Deletes the first node in the list.
     */
    public void deleteFirst() {

        if (head == null) { // if the list is empty
            System.out.println("Cannot delete from an empty list"); // print an error message
            return;
        }

        if (head == tail) { // if there is only one node in the list
            head = head.next; // set the head to null
            tail = head; // set the tail to null
            size--; // decrement the size of the list
            return;
        }

        head = head.next; // set the head to the next node in the list
        size--; // decrement the size of the list
        return;
    }

    /**
     * Deletes the last node in the list.
     */
    public void deleteLast() {

        if (tail == null) { // if the list is empty
            deleteFirst(); // delete the first node in the list
        }

        if (head == tail) { // if there is only one node in the list
            deleteFirst(); // delete the first node in the list
        }

        Node temp = head; // start at the head of the list
        while (temp.next != tail) { // traverse the list until the node before the tail is reached
            temp = temp.next;
        }

        temp.next = null; // set the next pointer of the node before the tail to null
        tail = temp; // set the tail to the node before the tail
        size--; // decrement the size of the list
        return;
    }

    /**
     * Deletes the node at the specified index in the list.
     * 
     * @param index the index of the node to be deleted
     */
    public void deleteAtIndex(int index) {

        if (index == 0) { // if the first node should be deleted
            deleteFirst(); // delete the first node in the list
            return;
        }

        if (index == size) { // if the last node should be deleted
            deleteLast(); // delete the last node in the list
            return;
        }

        Node temp = head; // start at the head of the list
        int i = 0;
        while (i != index - 1) { // traverse the list until the node before the deletion point is reached
            temp = temp.next;
            i++;
        }

        if (temp.next != null) { // if the node to be deleted is not the last node in the list
            temp.next = temp.next.next; // set the next pointer of the node before the deletion point to the node after the deletion point
            size--; // decrement the size of the list
            return;
        }
    }

    /**
     * Displays the contents of the list.
     */
    public void display() {

        if (tail == null) { // if the list is empty or has only one node
            System.out.println(head); // print the head of the list
        }

        Node temp = head; // start at the head of the list

        while (temp != null) { // traverse the list until the end is reached
            System.out.print(temp.val + " -> "); // print the value of the current node
            temp = temp.next; // move to the next node
        }
        System.out.print("END"); // print "END" to indicate the end of the list
    }

    /**
     * Constructs an empty linked list.
     */
    public LL() {
        this.size = 0; // set the size of the list to 0
    }

    /**
     * A class that represents a node in a singly linked list.
     */
    private class Node {
        private int val; // the value stored in the node
        private Node next; // the next node in the list

        /**
         * Constructs a node with the given value and null next pointer.
         * 
         * @param val the value to be stored in the node
         */
        public Node(int val) {
            this.val = val;
        }

        /**
         * Constructs a node with the given value and next pointer.
         * 
         * @param val  the value to be stored in the node
         * @param next the next node in the list
         */
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * A main method to test the functionality of the linked list.
     */
    public static void main(String[] args) {
        LL list = new LL(); // create a new linked list
        list.insertFirst(3); // insert a node with value 3 at the beginning of the list
        list.insertLast(5); // insert a node with value 5 at the end of the list
        list.insertLast(5); // insert a node with value 5 at the end of the list
        list.insertLast(5); // insert a node with value 5 at the end of the list
        list.insertLast(5); // insert a node with value 5 at the end of the list
        list.insertAtIndex(4, 2); // insert a node with value 4 at index 2 in the list
        list.insertAtIndex(7, list.size); // insert a node with value 7 at the end of the list
        list.insertAtIndex(8, 7); // insert a node with value 8 at index 7 in the list
        list.deleteFirst(); // delete the first node in the list
        list.deleteFirst(); // delete the first node in the list
        list.deleteLast(); // delete the last node in the list
        list.display(); // display the contents of the list
    }
}