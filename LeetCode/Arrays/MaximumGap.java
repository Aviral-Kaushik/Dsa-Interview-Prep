package LeetCode.Arrays;

import java.util.Arrays;

public class MaximumGap {

    /**
     * Efficient Method
     * Time Complexity: O(n log n)
     * Space Complexity: O(1)
     * */
    public int maximumGap(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        Arrays.sort(nums);

        int maximumGap = 0;
        for (int i = 1; i < nums.length; i++) {
            int difference = nums[i] - nums[i - 1];
            maximumGap = Math.max(maximumGap, difference);
        }

        return maximumGap;
    }
}
