package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    public List<String> summaryRanges(int[] nums) {
        List<String> results = new ArrayList<>();
        int n = nums.length;
        int i = 0;

        while (i < n) {
            int start = nums[i];

            while (i < n - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            }

            if (start != nums[i]) {
                results.add(start + "->" + nums[i]);
            } else {
                results.add(String.valueOf(start));
            }

            i++;
        }

        return results;
    }
}
