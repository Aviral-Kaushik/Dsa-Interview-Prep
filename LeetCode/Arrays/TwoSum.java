package LeetCode.Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    /**
     * Brute Force Approach
     * Time Complexity: O(n ^ 2)
     * Space Complexity: O(1)
     * */
    private static int[] bruteForceApproach(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }

    /**
     * Efficient Approach
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static int[] efficientApproach(int[] nums, int target) {
        HashMap<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (numToIndex.containsKey(complement)) {
                return new int[]{numToIndex.get(complement), i};
            }

            numToIndex.put(nums[i], i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bruteForceApproach(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(efficientApproach(new int[]{2, 7, 11, 15}, 9)));

        System.out.println(Arrays.toString(bruteForceApproach(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(efficientApproach(new int[]{3, 2, 4}, 6)));

        System.out.println(Arrays.toString(bruteForceApproach(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(efficientApproach(new int[]{3, 3}, 6)));
    }
}
