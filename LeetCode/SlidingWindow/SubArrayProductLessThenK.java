package LeetCode.SlidingWindow;

public class SubArrayProductLessThenK {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    public int numSubArrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int currentProduct = 1;
        int subArrayCount = 0;

        for (int right = 0; right < nums.length; right++) {
            currentProduct *= nums[right];

            while (left <= right && currentProduct >= k) {
                currentProduct /= nums[left++];
            }

            subArrayCount += right - left + 1;
        }

        return subArrayCount;
    }
}
