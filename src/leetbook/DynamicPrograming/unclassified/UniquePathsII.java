package leetbook.DynamicPrograming.unclassified;

/**
 * LC 63
 *
 * @author: Yihu4
 * @create: 2021-11-30 14:58
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        // 第一列一旦遇到石头,后面都无路可走
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }

        // 第一行一旦遇到石头,后面都无路可走
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }

        // 考虑非第一行第一列的区域
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else {
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }

        }
        return dp[dp.length-1][dp[0].length-1];
    }

    // 一维
    public int uniquePathsWithObstaclesOneDim(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    // 遇到石头置零
                    dp[j] = 0;
                else if (j > 0)
                    // 等价于上一个加左边的那一个
                    dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];
    }
}
