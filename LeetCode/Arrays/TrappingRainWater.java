package LeetCode.Arrays;

public class TrappingRainWater {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    public int trap(int[] height) {
        int trappedWater = 0;

        int left = 1, right = height.length - 2;

        // lMax : Maximum in subarray arr[0..left-1]
        // rMax : Maximum in subarray arr[right+1..n-1]
        int leftMax = height[left - 1], rightMax = height[right + 1];

        while (left <= right) {

            // If rMax is smaller, then we can decide
            // the amount of water for arr[right]
            if (rightMax <= leftMax) {
                // Add the water for arr[right]
                trappedWater += Math.max(0, rightMax - height[right]);

                // Update right max
                rightMax = Math.max(rightMax, height[right]);

                // Update right pointer as we have decided the amount of water for this
                right--;
            } else {
                // Add the water for arr[left]
                trappedWater += Math.max(0, leftMax - height[left]);

                // Update left max
                leftMax = Math.max(leftMax, height[left]);

                // Update left pointer as we have
                // decided water for this
                left++;
            }
        }

        return trappedWater;
    }
}
