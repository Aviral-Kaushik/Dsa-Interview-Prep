package LeetCode.Arrays;

public class BestTimeToBuyAndSellStockII {

    /// Multiple Transaction Allowed

    /**
     * Efficient Solution
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int lMin = prices[0]; // Local Minima
        int lMax = prices[0]; // Local Maxima
        int profit = 0;

        int i = 0;

        while (i < n - 1) {

            // Find Local Minima
            while (i < n - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            lMin = prices[i];

            // Find Local Maxima
            while (i < n - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            lMax = prices[i];

            profit += lMax - lMin;
        }

        return profit;
    }
}
