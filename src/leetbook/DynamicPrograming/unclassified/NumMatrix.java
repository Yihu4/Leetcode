package leetbook.DynamicPrograming.unclassified;

/**
 * LC 304
 * Range Sum Query 2D - Immutable
 *
 * @author: Yihu4
 * @create: 2021-11-30 10:49
 */
public class NumMatrix {
    int[][] dp;

    public NumMatrix(int[][] matrix) {
        if (matrix.length > 0) {
            dp = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    dp[i+1][j+1]=matrix[i][j]+dp[i][j+1]+dp[i+1][j]-dp[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2+1][col2+1]-dp[row1][col2+1]-dp[row2+1][col1]+dp[row1][col1];
    }
}
