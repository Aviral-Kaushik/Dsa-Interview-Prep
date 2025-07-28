package LeetCode.Matrix;

public class RotateMatrixBy90Degrees {

    /**
     * Efficient Method
     * Time Complexity: O(m * n)
     * Space Complexity: O(1)
     * */
    // Method to rotate the matrix by 90 degrees clockwise
    public static void rotate(int[][] matrix) {
        // Step 1: Transpose the matrix
        // Swap matrix[i][j] with matrix[j][i]
        // We iterate only over the upper triangle to avoid double swapping
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < matrix.length; i++) {
            // Use two pointers to reverse the row in-place
            int left = 0;
            int right = matrix.length - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
