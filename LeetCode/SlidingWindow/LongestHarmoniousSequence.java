package LeetCode.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSequence {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    public int findLHS(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num: nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int longestHS = 0;

        for (int num: nums) {
            if (freqMap.containsKey(num + 1)) {
                int currentLength = freqMap.get(num) + freqMap.get(num + 1);

                longestHS = Math.max(longestHS, currentLength);
            }
        }

        return longestHS;
    }
}
