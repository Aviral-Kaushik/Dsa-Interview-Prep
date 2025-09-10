package LeetCode.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {

    /**
     * Time Complexity: O(n)
     * Space Complexity; O(n)
     * */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSums = new HashMap<>();
        int count = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k)
                count++;

            count += prefixSums.getOrDefault(sum - k, 0);

            prefixSums.put(sum, prefixSums.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
