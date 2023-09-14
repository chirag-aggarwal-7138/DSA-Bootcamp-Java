public class LL {

    private Node head;
    private Node tail;
    private int size;


    public LL() {
        this.size = 0;
    }


    // Insertion
    public void insertFirst(int value) {
        Node node = new Node(value);

        if (head == null) {
            tail = node;
        }

        node.next = head;
        head = node;
        size++;
    }

    public void insertLast(int value) {
        Node node = new Node(value);

        if (tail == null) {
            insertFirst(value);
            return;
        }
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int value, int index) {
        Node node = new Node(value);

        if (index == 0) {
            insertFirst(value);
            return;
        } else if (index == size) {
            insertLast(value);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;

        size++;
    }


    // Deletion
    public int deleteFirst() {
        if (head == null) {
            return -1;
        } else if (head == tail) {
            int val = head.value;
            head = null;
            tail = null;
            return val;
        }

        int val = head.value;
        head = head.next;
        size--;
        return val;
    }

    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }

        Node node = get(size - 2);
        int val = tail.value;
        node.next = null;
        tail = node;
        size--;
        return val;
    }

    public int delete(int index) {
        if (index == 0) {
            return deleteFirst;
        } else if (index == size - 1) {
            return deleteLast();
        }

        Node node = get(index - 1);

        int val = node.next.value;
        node.next = node.next.next;
        size--;
        return val;
    }

    // Display
    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value + "->");
            temp= temp.next;
        }
        System.out.println("END");
    }

    // Node
    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(int value) {
            this.value = value;
        }        
    }
}
