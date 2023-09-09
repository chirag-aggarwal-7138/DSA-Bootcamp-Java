public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int ptr = -1;

    public CustomStack() {
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size) {
        this.data = new int[size];
    }

    public boolean push(int item) {
        if (isFull()) {
            System.out.println("Stack is Full");
            return false;
        }

        data[++ptr] = item;
        return true;
    }

    public int pop(int item) {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }

        return data[ptr--];
    }

    public boolean isFull() {
        return ptr == data.length - 1;
    }

    public boolean isEmpty() {
        return ptr == -1;

    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
        }

        return data[ptr];

    }
}