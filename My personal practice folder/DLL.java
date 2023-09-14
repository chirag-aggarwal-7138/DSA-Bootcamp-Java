public class DLL {

    private Node head;

    // Insert
    public void insertFirst(int value) {
        Node node = new Node(value);

        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        } 
        head = node;
    }

    public void insertLast(int value) {
        Node node = new Node(value);
        node.next = null;

        Node temp = head;

        if (head == null) {
            node.prev = null;
            head = node;
            return;
        }

        while (temp != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
    }

    public void insert(int after, int value) {
        Node afterNode = get(after);

        if (afterNode == null) {
            System.out.println("Not Found");
            return;
        }

        Node node = new Node(value);
        node.next = afterNode.next;

        if (afterNode.next != null) {
            afterNode.next.prev = node;
        }

        afterNode.next = node;
        node.prev = afterNode;
    }

    // Delete
    public int deleteFirst() {
        if (head == null) {
            return -1;
        }

        head = head.next;
        if (head != null) {
            head.prev = null;
        }
    }

    public int deleteLast() {

    }

    public int delete(int value) {

    }

    public Node get(int value) {
        Node temp = head;

        while (temp.value != value) {
            temp = temp.next;
        }
        return temp.next;
    }

    public void display() {
        Node temp = head;
        Node last = null;
        while (temp != null) {
            System.out.print(temp.value + "->");
            last = temp;
            temp = temp.next;
        }
        System.out.println("END");\
        
        System.out.println("Print in reverse");
        while (last != null) {
            System.out.print(last.value + "->");
            last = last.prev;
        }
        System.out.println("START");
    }

    // Node
    private class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node prev) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
    }
}
