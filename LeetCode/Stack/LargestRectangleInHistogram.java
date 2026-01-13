package LeetCode.Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LargestRectangleInHistogram {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int n = heights.length;

        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.pop()] = i;
            }

            left[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}
