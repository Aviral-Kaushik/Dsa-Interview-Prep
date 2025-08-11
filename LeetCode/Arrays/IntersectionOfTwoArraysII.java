package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {

    /**
     * Time Complexity: O(m + n)
     * Space Complexity: O(m + n)
     * Where m is the length of nums1 and n is the length of nums2.
     * */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freqMap  = new HashMap<>();
        List<Integer> intersection = new ArrayList<>();

        for (int num: nums1) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (int num: nums2) {
            if (freqMap.getOrDefault(num, 0) > 0) {
                intersection.add(num);
                freqMap .put(num, freqMap.get(num) - 1);
            }
        }

        int[] result = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            result[i] = intersection.get(i);
        }

        return result;
    }
}
