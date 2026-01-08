package LeetCode.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class OnlineStockSpan {

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(n)
     * */

    Deque<int[]> stack;

    public OnlineStockSpan() {
        this.stack= new ArrayDeque<>();
    }

    public int next(int price) {
        int span = 1;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        stack.push(new int[]{price, span});

        return span;
    }
}
