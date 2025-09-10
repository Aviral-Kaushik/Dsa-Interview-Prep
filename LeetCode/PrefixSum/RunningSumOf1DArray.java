package LeetCode.PrefixSum;

public class RunningSumOf1DArray {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] runningSum = new int[n];
        runningSum[0] = nums[0];

        for (int i = 1; i < n; i++) {
            runningSum[i] = runningSum[i - 1] + nums[i];
        }

        return runningSum;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    public int[] runningSumByChatGPT(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        return nums;
    }
}
