package LeetCode.SlidingWindow;

public class FindMaxAverageI {

    /**
     * Time Complexity: O(n)
     * Space Complexity: o(1)
     * */
    public double findMaxAverage(int[] nums, int k) {
        double maxAverage = Integer.MIN_VALUE;
        int left = 0;
        int currentSum = 0;

        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            if (right - left + 1 == k) {
                maxAverage = Math.max(maxAverage, (double) currentSum / k);
                currentSum -= nums[left];
                left++;
            }
        }

        return maxAverage;
    }
}
