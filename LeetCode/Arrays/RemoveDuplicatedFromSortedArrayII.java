package LeetCode.Arrays;

public class RemoveDuplicatedFromSortedArrayII {

    /// Problem: Remove Duplicated from Sorted Array that allows 2 duplicates and remove 3rd or more occurrences.

    /**
     * Efficient Method
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    public int removeDuplicates(int[] nums) {
        int res = 1;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                count++;
            else
                count = 1;

            if (count <= 2) {
                nums[res] = nums[i];
                res++;
            }
        }

        return res;
    }

}
