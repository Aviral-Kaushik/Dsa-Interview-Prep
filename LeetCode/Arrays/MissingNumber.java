package LeetCode.Arrays;

public class MissingNumber {

    /**
     * Efficient Method
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = (n * (n + 1)) / 2;
        int currentSum = 0;

        for (int i = 0; i < n; i++) {
            currentSum += nums[i];
        }

        return expectedSum - currentSum;
    }
}
