package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountOfSmallerElementAfterSelf {

    /// This solution is not done by me it is done by ChatGPT.

    /**
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     * */
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] result = new Integer[n];
        int[][] arr = new int[n][2]; // value, original index

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
            result[i] = 0;
        }

        mergeSort(arr, 0, n - 1, result);

        return Arrays.asList(result);
    }

    private void mergeSort(int[][] arr, int left, int right, Integer[] result) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, result);
        mergeSort(arr, mid + 1, right, result);

        merge(arr, left, mid, right, result);
    }

    private void merge(int[][] arr, int left, int mid, int right, Integer[] result) {
        List<int[]> temp = new ArrayList<>();
        int i = left, j = mid + 1;
        int rightCount = 0;

        while (i <= mid && j <= right) {
            if (arr[j][0] < arr[i][0]) {
                rightCount++;
                temp.add(arr[j++]);
            } else {
                result[arr[i][1]] += rightCount;
                temp.add(arr[i++]);
            }
        }

        while (i <= mid) {
            result[arr[i][1]] += rightCount;
            temp.add(arr[i++]);
        }

        while (j <= right) {
            temp.add(arr[j++]);
        }

        for (int k = left; k <= right; k++) {
            arr[k] = temp.get(k - left);
        }
    }
}
