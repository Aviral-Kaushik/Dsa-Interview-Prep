package LeetCode.Arrays;

import java.util.Arrays;

public class ThreeSumCloset {

    /**
     * Efficient Solution
     * Time Complexity: O(n ^ 2)
     * Space Complexity: O(1)
     * */
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int minimumDifference = Integer.MAX_VALUE;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                int currentDifference = Math.abs(currentSum - target);

                if (currentDifference < minimumDifference) {
                    minimumDifference = currentDifference;
                    result = currentSum;
                }

                if (currentSum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return result;
    }
}
