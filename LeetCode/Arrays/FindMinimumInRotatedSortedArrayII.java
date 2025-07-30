package LeetCode.Arrays;

public class FindMinimumInRotatedSortedArrayII {

    /// Sorted Rotated Array might contain duplicates.

    /**
     * Efficient Method
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * */
    public int findMin(int[] nums) {
        int minimum = nums[0];

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            minimum = Math.min(nums[mid], minimum);

            if (nums[mid] == nums[left]) {
                left++;
            } else if (nums[mid] == nums[right]) {
                right--;
            } else if (nums[left] > nums[mid]) {
                if (nums[left] >= minimum) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[right] <= minimum) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return minimum;
    }
}
