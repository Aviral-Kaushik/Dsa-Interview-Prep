package LeetCode.Stack;

import java.util.*;

public class NextGreaterElementII {

    /**
     * Time Complexity:O(n)
     * Space Complexity: O(n)
     * */
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[n];

        Arrays.fill(res, -1);

        for (int i = 2 * n - 1; i >= 0; i--) {
            int current = nums[i % n];

            while (!stack.isEmpty() && current >= stack.peek()) {
                stack.pop();
            }

            if (i < n && !stack.isEmpty()) {
                res[i] = stack.peek();
            }

            stack.push(current);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] testCase1 = {1, 2, 1};
        int[] testCase2 = {1, 2, 3, 4, 3};
        int[] testCase3 = {100,1,11,1,120,111,123,1,-1,-100};

        System.out.println(Arrays.toString(nextGreaterElements(testCase1)));
        System.out.println(Arrays.toString(nextGreaterElements(testCase2)));
        System.out.println(Arrays.toString(nextGreaterElements(testCase3)));
    }
}
