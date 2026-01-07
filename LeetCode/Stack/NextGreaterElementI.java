package LeetCode.Stack;

import java.util.*;

public class NextGreaterElementI {

    /**
     * Time Complexity: O(m + n)
     * Space Complexity: O(m)
     * */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int num: nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        int[] res = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] testCase1Nums1 = {4, 1, 2};
        int[] testCase1Nums2 = {1, 3, 4, 2};
        int[] testCase2Nums1 = {2, 4};
        int[] testCase2Nums2 = {1, 2, 3, 4};

        System.out.println(Arrays.toString(nextGreaterElement(testCase1Nums1, testCase1Nums2)));
        System.out.println(Arrays.toString(nextGreaterElement(testCase2Nums1, testCase2Nums2)));
    }

}
