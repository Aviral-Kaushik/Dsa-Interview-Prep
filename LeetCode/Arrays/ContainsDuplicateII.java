package LeetCode.Arrays;

import java.util.HashMap;

public class ContainsDuplicateII {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int index = map.get(nums[i]);

                if (Math.abs(index - i) <= k) {
                    return true;
                }
            }

            map.put(nums[i], i);
        }

        return false;
    }
}
