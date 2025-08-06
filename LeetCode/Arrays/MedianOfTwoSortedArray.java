package LeetCode.Arrays;

public class MedianOfTwoSortedArray {

    /**
     * Merge (Efficient) Method
     * Time Complexity: O(m + n)
     * Space Complexity: O(m + n)
     * */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] temp = new int[m + n];
        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                temp[k++] = nums1[i++];
            } else {
                temp[k++] = nums2[j++];
            }
        }

        while (i < m) {
            temp[k++] = nums1[i++];
        }

        while (j < n) {
            temp[k++] = nums2[j++];
        }

        if (temp.length % 2 == 0) {
            int mid = temp.length / 2;
            return (temp[mid - 1] + temp[mid]) / 2.0;
        } else {
            return temp[temp.length / 2];
        }
    }
}
