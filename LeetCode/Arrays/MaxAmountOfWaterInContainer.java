package LeetCode.Arrays;

public class MaxAmountOfWaterInContainer {

    /**
     * Brute Force Approach
     * Time Complexity: O(n ^ 2)
     * Space Complexity: O(1)
     * */
    private int bruteForceApproach(int[] height) {
        int maxArea = 1;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int currentArea = Math.min(height[i], height[j]) * (j - i);
                maxArea = Math.max(currentArea, maxArea);
            }
        }

        return maxArea;
    }

    /**
     * Efficient Approach
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    private int efficientApproach(int[] height) {
        int maxArea = 1;

        int left = 0, right = height.length - 1;

        while (left < right) {
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(currentArea, maxArea);
        }

        return maxArea;
    }
}
