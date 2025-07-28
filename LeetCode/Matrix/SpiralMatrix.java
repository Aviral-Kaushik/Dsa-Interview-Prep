package LeetCode.Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    /**
     * Efficient Method:
     * Time Complexity: O(m * n)
     * Space Complexity: O(1)
     * */
    private List<Integer> spiralTraversalOfMatrix(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;


        // Initialize boundaries
        int top = 0, bottom = m - 1, left = 0, right = n - 1;

        // Iterate until all elements are printed
        while (top <= bottom && left <= right) {

            // Print top row from left to right
            for (int i = left; i <= right; ++i) {
                res.add(matrix[top][i]);
            }
            top++;

            // Print right column from top to bottom
            for (int i = top; i <= bottom; ++i) {
                res.add(matrix[i][right]);
            }
            right--;

            // Print bottom row from right to left (if exists)
            if (top <= bottom) {
                for (int i = right; i >= left; --i) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Print left column from bottom to top (if exists)
            if (left <= right) {
                for (int i = bottom; i >= top; --i) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }

        return res;
    }

}
