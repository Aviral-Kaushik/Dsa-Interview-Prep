package LeetCode.Stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public ImplementStackUsingQueues() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }

    public void push(int element) {
        queue2.add(element);

        while (!queue1.isEmpty()) {
            queue2.add(queue1.peek());
            queue1.remove();
        }

        Queue<Integer> temp = queue2;
        queue2 = queue1;
        queue1 = temp;
    }

    public int pop() throws Exception {
        if (isEmpty()) throw new Exception("Stack Underflow!");
        return queue1.remove();
    }

    public int peek() throws Exception {
        if (isEmpty()) return -1;
        return queue1.peek();
    }

    public int size() {
        return queue1.size();
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }
}
