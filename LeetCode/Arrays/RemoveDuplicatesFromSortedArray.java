package LeetCode.Arrays;

public class RemoveDuplicatesFromSortedArray {

    /**
     * Efficient Method
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    public int removeDuplicates(int[] nums) {
        int res = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[res] = nums[i];
                res++;
            }
        }

        return res;
    }

}
