public class CustomStack {
    
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    private int ptr = -1;

    public void push(int item) {
        if (isFull) {
            System.out.println("Stack is full");
            return;
        }
        ptr++;
        data[ptr] = item;
        return;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Empty stack");
            return -1;
        }

        int removed = data[ptr];
        ptr--;
        return removed;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }

        return data[ptr];
    }

    public boolean isFull() {
        return ptr == data.length - 1;
    }

    public boolean isEmpty() {
        return ptr == -1;
    }

    public CustomStack(int size) {
        this.data = new int[size];

    }

    public CustomStack() {
        this.data = new int[DEFAULT_SIZE];

    }
}
