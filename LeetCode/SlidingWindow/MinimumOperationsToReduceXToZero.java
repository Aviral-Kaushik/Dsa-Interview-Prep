package LeetCode.SlidingWindow;

public class MinimumOperationsToReduceXToZero {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;

        for (int num: nums) {
            totalSum += num;
        }

        int target = totalSum - x;

        if (target < 0)
            return -1;

        if (target == 0)
            return nums.length;

        int sum = 0;
        int left = 0;
        int maxLength = -1;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum > target && left <= right) {
                sum -= nums[left];
                left++;
            }

            if (sum == target)
                maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength == -1 ? -1 : nums.length - maxLength;
    }
}
