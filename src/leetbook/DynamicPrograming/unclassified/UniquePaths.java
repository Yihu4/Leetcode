package leetbook.DynamicPrograming.unclassified;

/**
 * LC 62
 * @author: Yihu4
 * @create: 2021-11-30 11:56
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0||j==0){
                    // 如果在第一行或者第一列,那么只有一条路
                    dp[i][j]=1;
                }else {
                    // 其他地方,那么路线由左边一格和上面一格相加转换而来
                    dp[i][j]= dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
