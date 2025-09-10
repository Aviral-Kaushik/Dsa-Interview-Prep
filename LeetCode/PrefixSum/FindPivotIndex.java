package LeetCode.PrefixSum;

public class FindPivotIndex {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        int n = nums.length;
        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }

        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum)
                return i;

            leftSum += nums[i];
        }

        return -1;
    }
}
