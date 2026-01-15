package LeetCode.Queue;

public class DesignCircularQueue {

    private final int[] arr;
    private int front;
    private final int capacity;
    private int size;

    public DesignCircularQueue(int k) {
        arr = new int[k];
        front = 0;
        capacity = k;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (size == capacity) return false;
        int rear = (front + size) % capacity;
        arr[rear] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (size == 0) return false;
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    public int Front() {
        if (size == 0) return -1;
        return arr[front];
    }

    public int Rear() {
        if (size == 0) return -1;
        int rear = (front + size - 1) % capacity;
        return arr[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
