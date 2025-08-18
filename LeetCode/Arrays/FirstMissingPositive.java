package LeetCode.Arrays;

public class FirstMissingPositive {

    /**
     * Efficient Method
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    public int firstMissingPositiveUsingEfficientMethod(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            // if arr[i] is within the range [1, n] and arr[i]
            // is not placed at (arr[i]-1)th index in arr
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {

                // then swap arr[i] and arr[arr[i]-1] to
                // place arr[i] to its corresponding index
                swap(nums, i, nums[i] - 1);
            }
        }

        // If any number is not at its corresponding index
        // then it is the missing number
        for (int i = 1; i <= n; i++) {
            if (i != nums[i - 1]) {
                return i;
            }
        }

        // If all number from 1 to n are present then n+1
        // is smallest missing number
        return n + 1;
    }

    private void swap(int[] nums, int low, int high) {
        int temp = nums[low];
        nums[low] = nums[high];
        nums[temp - 1] = temp;
    }

    /**
     * Naive Method
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    public int firstMissingPositiveUsingNaiveMethod(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[n + 1];

        for (int num: nums) {
            if (num > 0 && num <= n) {
                seen[num] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!seen[i]) {
                return i;
            }
        }

        return n + 1;
    }
}
