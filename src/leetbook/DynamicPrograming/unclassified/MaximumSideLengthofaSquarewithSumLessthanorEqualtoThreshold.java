package leetbook.DynamicPrograming.unclassified;

import org.junit.Test;

/**
 * LC 1292
 * 返回矩阵中 正方形内相加小于等于threshold的边长
 * @author: Yihu4
 * @create: 2021-11-30 16:57
 */
public class MaximumSideLengthofaSquarewithSumLessthanorEqualtoThreshold {
    @Test
    public void test(){
        int[][] i = {{18,70},{61,1},{25,85},{14,40},{11,96},{97,96},{63,45}};
        System.out.println(maxSideLength(i, 40184));
    }
    public int maxSideLength(int[][] mat, int threshold) {
        //前缀和
        int[][] dp = new int[mat.length + 1][mat[0].length+1];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                dp[i+1][j+1]=mat[i][j]+dp[i][j+1]+dp[i+1][j]-dp[i][j];
            }
        }

        int res = 0;
        // 正方形
        for (int k = 1; k <= Math.min(mat.length, mat[0].length); k++) {
            for (int i = 1; i <= mat.length; i++) {
                for (int j = 1; j <= mat[0].length; j++) {
                    if (i-k<0||j-k<0){
                        continue;
                    }
                    int cur = dp[i][j]-dp[i-k][j]-dp[i][j-k]+dp[i-k][j-k];
                    if (cur<=threshold){
                        res = Math.max(res,k);
                    }
                }
            }
        }
        return res;
    }
}
