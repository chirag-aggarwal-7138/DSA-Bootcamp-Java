public class CircularQueue {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    protected int end = 0;
    protected int front = 0;
    private int size = 0;

    public CircularQueue(){
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return size == data.length; // ptr is at last index
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean insert(int item) {
        if (isFull()) {
            System.out.println("Queue is Full");
            return false;
        }
        data[end++] = item;
        end = end % data.length;
        size++;
        return true;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int removed = data[front++];
        front = front % data.length;
        size--;
        return removed;
    }

    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return data[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        int i = front;
        do {
            System.out.println(data[i] + " ");
            i++;
            i = i % data.length;
        } while (i != end);
        System.out.println("END");
    }
}