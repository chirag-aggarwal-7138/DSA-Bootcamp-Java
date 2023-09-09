public class CustomQueue {
    
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int end = -1;

    public CustomQueue() {
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size) {
        this.data = new int[size];
    }

    public boolean insert(int item) {
        if (isFull) {
            System.out.println("Queue is Full");
            return false;
        }
        data[end++] = item;
        return true;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int del = data[0];

        for (int i = 0; i < end; i++) {
            data[i - 1] = data[i];
        }
        end--;
        return del;
    }

    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return data[0];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
        } else {
            for (int i = 0; i < end; i++) {
                System.out.println(data[i] + " ");
            }
        }
        System.out.println("END");
    }

    public boolean isFull() {
        return end == data.length - 1;
    }

    public boolean isEmpty() {
        return end == -1;

    }
}
