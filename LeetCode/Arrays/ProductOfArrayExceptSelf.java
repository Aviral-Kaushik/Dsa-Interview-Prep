package LeetCode.Arrays;

public class ProductOfArrayExceptSelf {

    /**
     * Naive Method
     * Time Complexity: O(n ^ 2)
     * Space Complexity: O(1)
     * */
    public int[] productExceptSelfNaiveMethod(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }

            result[i] = product;
        }

        return result;
    }

    /**
     * Efficient Method
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    public int[] productExceptSelfEfficientMethod(int[] nums) {
        int n = nums.length;
        int[] prefixProduct = new int[n];
        int[] suffixProduct = new int[n];
        int[] result = new int[n];


        prefixProduct[0] = 1;
        for (int i = 1; i < n; i++) {
            prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
        }

        suffixProduct[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffixProduct[i] = nums[i + 1] * suffixProduct[i + 1];
        }

        for (int i = 0; i < n; i++) {
            result[i] = suffixProduct[i] * prefixProduct[i];
        }

        return result;
    }
}
