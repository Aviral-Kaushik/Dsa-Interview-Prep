package LeetCode.Arrays;

public class PeakElement {

    /**
     * Efficient Method
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    public int findPeakElement(int[] nums) {
        if (nums.length <= 1)
            return 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                if (nums.length > i + 1) {
                    if (nums[i] > nums[i + 1]) {
                        return i;
                    }
                } else {
                    if (nums[i] > nums[i - 1]) {
                        return i;
                    }
                }
            } else {
                return i - 1;
            }
        }

        return -1;
    }
}
