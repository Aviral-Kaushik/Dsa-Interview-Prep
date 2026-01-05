package LeetCode.Stack;

import java.util.Stack;

class MinStack {

    private final Stack<Long> stack;
    private long min;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int element) {
        long val = element;

        if (stack.isEmpty()) {
            stack.push(val);
            min = val;
        } else if (val <= min) {
            stack.push(2 * val - min);
            min = val;
        } else {
            stack.push(val);
        }
    }

    public void pop() {
        long res = stack.pop();

        if (res <= min) {
            min = 2 * min - res;
        }
    }

    public int top() {
        long top = stack.peek();
        return (int) ((top <= min) ? min : top);
    }

    public int getMin() {
        return (int) min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */