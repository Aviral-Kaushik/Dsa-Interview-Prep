package LeetCode.Arrays;

import java.util.*;

public class RandomizedSet {

    /**
     * Time Complexity: O(1) (All Methods)
     * Space Complexity: O(n)
     * */

    private final Map<Integer, Integer> indexMap;
    private final List<Integer> values;
    private final Random random;

    public RandomizedSet() {
        indexMap = new HashMap<>();
        values = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            return false;
        }

        indexMap.put(val, values.size());
        values.add(val);

        return true;
    }

    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false;
        }

        int index = indexMap.get(val);
        int lastElement = values.get(values.size() - 1);

        // Swap last element into the removed spot
        values.set(index, lastElement);
        indexMap.put(lastElement, index);

        // Remove last element
        values.remove(values.size() - 1);
        indexMap.remove(val);

        return true;
    }

    public int getRandom() {
        return values.get(random.nextInt(values.size()));
    }
}
