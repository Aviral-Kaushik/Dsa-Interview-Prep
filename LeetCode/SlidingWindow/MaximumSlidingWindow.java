package LeetCode.SlidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MaximumSlidingWindow {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(k)
     * */
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(i);
        }

        for (int right = k; right < nums.length; right++) {
            res.add(nums[deque.peekFirst()]);

            while (!deque.isEmpty() && deque.peekFirst() <= right - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[right] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(right);
        }

        res.add(nums[deque.peekFirst()]);

        int[] result = new int[res.size()];
        int index = 0;

        for (Integer element: res) {
            result[index++] = element;
        }

        return result;
    }
}
