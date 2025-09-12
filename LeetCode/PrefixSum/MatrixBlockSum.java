package LeetCode.PrefixSum;

public class MatrixBlockSum {

    /**
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n)
     * */
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int rows = mat.length;
        int columns = mat[0].length;

        int[][] prefixSum = new int[rows + 1][columns + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                prefixSum[i][j] = mat[i - 1][j - 1] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }

        int[][] result = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                int topRow = Math.max(i - k, 0);
                int leftCol = Math.max(j - k, 0);
                int bottomRow = Math.min(rows - 1, i + k);
                int rightCol = Math.min(columns - 1, j + k);

                result[i][j] = prefixSum[bottomRow + 1][rightCol + 1]
                        - prefixSum[topRow][rightCol + 1]
                        - prefixSum[bottomRow + 1][leftCol]
                        + prefixSum[topRow][leftCol];
            }
        }

        return result;
    }
}
