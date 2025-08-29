package LeetCode.SlidingWindow;

public class MaxConsecutiveOnesIII {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    public int longestOnes(int[] nums, int k) {
        int start = 0, end = 0;
        int longest1s = 0, countOf0s = 0;

        while (end < nums.length) {
            if (nums[end] == 0)
                countOf0s++;

            while (countOf0s > k) {
                if (nums[start] == 0)
                    countOf0s--;

                start++;
            }

            longest1s = Math.max(longest1s, end - start + 1);

            end++;
        }

        return longest1s;
    }
}
