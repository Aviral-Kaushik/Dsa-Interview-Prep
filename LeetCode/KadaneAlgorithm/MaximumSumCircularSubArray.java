package LeetCode.KadaneAlgorithm;

public class MaximumSumCircularSubArray {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int currentMaxSum = 0, currentMinSum = 0;
        int maxSum = nums[0], minSum = nums[0];

        for (int num : nums) {
            currentMaxSum = Math.max(currentMaxSum + num, num);
            maxSum = Math.max(maxSum, currentMaxSum);

            currentMinSum = Math.min(currentMinSum + num, num);
            minSum = Math.min(minSum, currentMinSum);

            totalSum += num;
        }

        int normalSum = maxSum;
        int circularSum = totalSum - minSum;

        if (totalSum == minSum)
            return normalSum;

        return Math.max(normalSum, circularSum);
    }
}
