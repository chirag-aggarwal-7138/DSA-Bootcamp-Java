public class CLL {
    private Node head;
    private Node tail;

    // Constructor
    public CLL() {
        this.head = null;
        this.tail = null;
    }

    public void insert(int value) {
        Node node = new Node(value);

        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void delete(int value) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        } else if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        Node temp = head;

        do {
            temp.next = temp.next.next;
            if (temp.next.value == value) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        } while (node != head);
    }

    public void display() {
        Node temp = head;

        if (head != null) {
            do {
                System.out.println(temp.value + "->");
                if (temp.next != null) {
                    temp = temp.next;
                }
            } while (temp != head);
        }
        System.out.println("HEAD");
    }

    // Node
    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
