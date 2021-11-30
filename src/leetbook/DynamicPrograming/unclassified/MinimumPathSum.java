package leetbook.DynamicPrograming.unclassified;

/**
 * LC 64
 * 记录最短路径
 * @author: Yihu4
 * @create: 2021-11-30 15:41
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0]=grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i==0&&j==0){
                    continue;
                }
                if (i==0){
                    dp[i][j]+=dp[i][j-1];
                }else if (j==0){
                    dp[i][j]+=dp[i-1][j];
                }else {
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1]);
                }
                dp[i][j]+=grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
