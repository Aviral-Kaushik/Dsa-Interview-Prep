package LeetCode.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SubArraysWithKDistinctElements {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    public int subArraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int left = 0;
        int totalSubArrays = 0;

        for (int right = 0; right < nums.length; right++) {
            int currentElementFrequency = freqMap.getOrDefault(nums[right], 0) + 1;
            freqMap.put(nums[right], currentElementFrequency);

            if (currentElementFrequency == 1)
                k--;

            while (k < 0) {
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);

                if (freqMap.get(nums[left]) == 0)
                    k++;

                left++;
            }

            totalSubArrays += (right - left + 1);
        }

        return totalSubArrays;
    }

}
