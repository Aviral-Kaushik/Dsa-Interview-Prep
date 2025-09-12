package LeetCode.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubArraySum {

    /**
     * Time Complexity = O(n)
     * Space Complexity: O(n)
     * */
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1);

        int runningSum = 0;

        for (int i = 0; i < nums.length; i++) {
            runningSum = (runningSum + nums[i]) % k;

            if (!remainderMap.containsKey(runningSum)) {
                remainderMap.put(runningSum, i);
            } else if (i - remainderMap.get(runningSum) > 1) {
                return true;
            }
        }

        return false;
    }
}
