package LeetCode.Arrays;

public class RemoveElementFromUnsortedArray {

    /**
     * Efficient Method
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    public int removeElement(int[] nums, int val) {
        int res = 0;

        for (int num: nums) {
            if (num != val) {
                nums[res] = num;
                res++;
            }
        }

        return res;
    }
}
