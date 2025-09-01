package LeetCode.SlidingWindow;

public class BinarySubArrayWithSum {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    public int numSubArraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private int atMost(int[] nums, int goal) {
        if (goal < 0)
            return 0;

        int n = nums.length;
        int res = 0, sum = 0, start = 0;

        for (int end = 0; end < n; end++) {

            while (start < n && sum + nums[start] <= goal) {
                sum += nums[start];
                start++;
            }

            // Number of sub-arrays starting from
            // index i that have sum atmost k will
            // be (j-i).
            res += (start - end);

            // Remove the i'th index from window.
            sum -= nums[end];
        }

        return res;
    }
}
