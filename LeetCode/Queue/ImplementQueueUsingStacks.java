package LeetCode.Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementQueueUsingStacks {

    /**
     * Time Complexity
     * push: O(1)
     * pop: O(n) (Amortized O(1))
     * peek: O(n) (Amortized O(1))
     * isEmpty: O(1)
     * Space Complexity: O(n)
     * */

    private final Deque<Integer> in;
    private final Deque<Integer> out;

    public ImplementQueueUsingStacks() {
        in = new ArrayDeque<>();
        out = new ArrayDeque<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        shift();
        return out.pop();
    }

    public int peek() {
        shift();
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    private void shift() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }
}
