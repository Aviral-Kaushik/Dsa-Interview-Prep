package LeetCode.Arrays;

public class SingleNumber {

    /**
     * Efficient Method
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    public int singleNumber(int[] nums) {
        int XOR = 0;

        for (int num: nums) {
            XOR ^= num;
        }

        return XOR;
    }
}
