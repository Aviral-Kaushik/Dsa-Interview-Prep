package LeetCode.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWater {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    public int trap(int[] height) {
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int poppedHeight = height[stack.pop()];

                if (stack.isEmpty()) break;

                int distance = i - stack.peek() - 1;

                int water = Math.min(height[stack.peek()], height[i]);

                water -= poppedHeight;

                result += distance * water;
            }

            stack.push(i);
        }

        return result;
    }
}
