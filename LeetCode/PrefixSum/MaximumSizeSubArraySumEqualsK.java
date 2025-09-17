package LeetCode.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubArraySumEqualsK {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private int maximumSizeSubArraySumEqualsK(int[] nums, int k) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        int prefixSum = 0;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if (prefixSum == k) {
                result++;
            } else if (prefixMap.containsKey(prefixSum - k)) {
                result = Math.max(result, i - prefixMap.get(prefixSum - k));
            }

            if (!prefixMap.containsKey(prefixSum)) {
                prefixMap.put(prefixSum, i);
            }
        }

        return result;
    }
}
