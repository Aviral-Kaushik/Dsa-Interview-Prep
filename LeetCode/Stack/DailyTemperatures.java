package LeetCode.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int poppedIndex = stack.pop();
                res[poppedIndex] = i - poppedIndex;
            }
            stack.push(i);
        }

        return res;
    }
}
