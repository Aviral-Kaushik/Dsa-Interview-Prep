package LeetCode.KadaneAlgorithm;

public class MaximumSubarray {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    private static int maximumSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maximumSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maximumSubArray(new int[]{1}));
        System.out.println(maximumSubArray(new int[]{5,4,-1,7,8}));
    }
}
