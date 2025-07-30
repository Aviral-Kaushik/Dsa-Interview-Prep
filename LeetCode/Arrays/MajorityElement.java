package LeetCode.Arrays;

import java.util.HashMap;

public class MajorityElement {

    /**
     * Efficient Method
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        int n = nums.length;

        for (int num: nums) {
            int count = frequencies.getOrDefault(num, 0) + 1;
            frequencies.put(num, count + 1);

            if (count > n / 2) {
                return num;
            }

        }

        return -1;
    }
}
