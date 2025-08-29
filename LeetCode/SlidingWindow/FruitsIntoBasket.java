package LeetCode.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> fruitsCount = new HashMap<>();
        int left = 0;
        int maxFruits = 0;

        for (int right = 0; right < fruits.length; right++) {
            fruitsCount.put(fruits[right], fruitsCount.getOrDefault(fruits[right], 0) + 1);

            if (fruitsCount.size() > 2) {
                fruitsCount.put(fruits[left], fruitsCount.get(fruits[left]) - 1);

                if (fruitsCount.get(fruits[left]) == 0) {
                    fruitsCount.remove(fruits[left]);
                }
                left++;
            }

            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }
}
