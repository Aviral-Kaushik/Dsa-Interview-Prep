package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {

    /**
     * Time Complexity: O(n * log n)
     * Space Complexity: O(n)
     * */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> result = new ArrayList<>();
        result.add(new int[]{intervals[0][0], intervals[0][1]});

        for (int i = 1; i < intervals.length; i++) {
            int[] last = result.get(result.size() - 1);
            int[] current = intervals[i];

            if (current[0] <= last[1])
                last[1] = Math.max(last[1], current[1]);
            else
                result.add(new int[]{current[0], current[1]});
        }

        int[][] mergedIntervals = new int[result.size()][2];
        int count = 0;

        for (int[] interval: result) {
            mergedIntervals[count] = interval;
            count++;
        }

        return mergedIntervals;
    }
}
