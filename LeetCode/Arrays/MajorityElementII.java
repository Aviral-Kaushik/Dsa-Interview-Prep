package LeetCode.Arrays;

import java.util.*;

public class MajorityElementII {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        int n = nums.length;

        // Count frequencies
        for (int num : nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }

        // Collect elements appearing more than n / 3 times
        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            if (entry.getValue() > n / 3) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}
