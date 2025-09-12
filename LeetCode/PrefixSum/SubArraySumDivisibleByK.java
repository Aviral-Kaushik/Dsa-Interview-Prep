package LeetCode.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumDivisibleByK {

    /**
     * Time Complexity = O(n)
     * Space Complexity: O(n)
     * */
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, 1);  // Base case: a sum of 0 modulo k occurs once initially.

        int count = 0;
        int runningSum = 0;

        for (int i = 0; i < nums.length; i++) {
            runningSum = runningSum + nums[i];   // Keep calculating running sum.

            int mod = runningSum % k;           // Take mod k.
            if (mod < 0) mod += k;              // Handle negative mods (important in Java).

            // If this mod has been seen before
            if (modMap.containsKey(mod)) {
                count += modMap.get(mod);       // Add number of previous occurrences of this mod.
                modMap.put(mod, modMap.get(mod) + 1);  // Increment count for this mod.
            } else {
                modMap.put(mod, 1);             // First time seeing this mod.
            }
        }

        return count;  // Total subarrays divisible by k.
    }

}
