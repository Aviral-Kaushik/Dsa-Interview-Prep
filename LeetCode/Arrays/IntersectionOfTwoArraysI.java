package LeetCode.Arrays;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArraysI {

    /**
     * Time Complexity: O(m + n)
     * Space Complexity: O(m + n)
     * Where m is the length of nums1 and n is the length of nums2.
     * */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> seenElements = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();

        for (int num: nums1) {
            seenElements.add(num);
        }

        for (int num: nums2) {
            if (seenElements.contains(num)) {
                intersection.add(num);
            }
        }

        int[] result = new int[intersection.size()];
        int index = 0;

        for (int num: intersection) {
            result[index++] = num;
        }

        return result;
    }
}
