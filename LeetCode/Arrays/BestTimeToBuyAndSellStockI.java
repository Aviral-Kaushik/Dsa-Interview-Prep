package LeetCode.Arrays;

public class BestTimeToBuyAndSellStockI {

    /**
     * Efficient Solution
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minimumPrice = prices[0];

        for (int price: prices) {
            minimumPrice = Math.min(minimumPrice, price);
            profit = Math.max(profit, price - minimumPrice);
        }

        return profit;
    }
}
