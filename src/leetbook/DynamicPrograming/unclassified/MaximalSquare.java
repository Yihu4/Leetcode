package leetbook.DynamicPrograming.unclassified;

import org.junit.Test;

/**
 * LC 221
 * 获取矩阵中最大的全为1的正方形
 * @author: Yihu4
 * @create: 2021-11-30 16:16
 */
public class MaximalSquare {
    @Test
    public void test(){
        char[][] chars = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(maximalSquare(chars));

    }
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]=='1'){
                    dp[i+1][j+1]=Math.min(dp[i][j],Math.min(dp[i][j+1],dp[i+1][j]))+1;
                }
                res = Math.max(res,dp[i+1][j+1]);
            }
        }
        return res*res;
    }
}
