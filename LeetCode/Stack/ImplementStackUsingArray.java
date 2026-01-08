package LeetCode.Stack;

public class ImplementStackUsingArray {

    private final int[] stack;
    private final int capacity;
    private int top;

    public ImplementStackUsingArray(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
        this.top = -1;
    }

    public void push(int element) throws Exception {
        if (top == capacity - 1)
            throw new Exception("Stack Overflow");

        stack[++top] = element;
    }

    private int pop() throws Exception {
        if (top == -1)
            throw new Exception("Stack Underflow");

        return stack[top--];
    }

    private int peek() {
        return stack[top];
    }

    private int size() {
        return top + 1;
    }

    private boolean isEmpty() {
        return top == -1;
    }
}
