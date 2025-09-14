package LeetCode.PrefixSum;

public class CountNumberOfNiceSubArrays {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            nums[i] %= 2;
        }

        int[] prefixCount = new int[n + 1];
        prefixCount[0] = 1;
        int sum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum >= k) {
                count += prefixCount[sum - k];
            }

            prefixCount[sum]++;
        }

        return count;
    }
}
