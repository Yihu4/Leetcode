package leetbook.DynamicPrograming.unclassified;

import org.junit.Test;

/**
 * LC 1314
 * 二位前缀和
 * @author: Yihu4
 * @create: 2021-11-29 20:38
 */
public class MatrixBlockSum {
    @Test
    public void test(){
        int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrixBlockSumSimple(ints,1);
    }
    // https://leetcode-cn.com/problems/matrix-block-sum/solution/lei-qian-zhui-he-dong-tai-gui-hua-hua-tu-53z6/
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] preSum = new int[mat.length][mat[0].length];

        for (int row = 0; row < preSum.length; row++) {
            for (int col = 0; col < preSum[row].length; col++) {
                // 二维数组前缀和是     之前行的前缀和 + 之前列的前缀和 - 重叠部分(即之前列和之前行的前缀和) + 本身的值
                preSum[row][col] = getMatrixNum( preSum, row-1, col)
                        + getMatrixNum( preSum, row, col-1)
                        - getMatrixNum( preSum, row-1, col-1)
                        + mat[row][col];
            }
        }

        int[][] answer = new int[mat.length][mat[0].length];
        for (int row = 0; row < answer.length; row++) {
            for (int col = 0; col < answer[row].length; col++) {
                // 每个点所囊括的区域由前缀和求得
                // 最大区域前缀和,减去上和左的,再加上负负得正的重叠部分
                answer[row][col] = getPreSumMatrixNum(preSum, row+k, col+k)
                        - getPreSumMatrixNum(preSum, row+k, col-k-1)
                        - getPreSumMatrixNum(preSum, row-k-1, col+k)
                        + getPreSumMatrixNum(preSum, row-k-1, col-k-1);
            }
        }
        return answer;
    }

    public int getMatrixNum(int[][] matrix, int row, int col){
        if (row < 0 || col < 0){
            return 0;
        }
        return matrix[row][col];
    }

    // 因为有边界,所以需要判断,行和列不能出边界
    public int getPreSumMatrixNum(int[][] matrix, int row, int col){
        if (row < 0 || col < 0){
            return 0;
        }
        row = Math.min(row, matrix.length - 1);
        col = Math.min(col, matrix[row].length - 1);
        return matrix[row][col];
    }

    // 简化版
    public int[][] matrixBlockSumSimple(int[][] mat, int k) {
        int n=mat.length,m=mat[0].length;
        int[][] dp=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1]+mat[i-1][j-1]-dp[i-1][j-1];
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                int x1=i-k,y1=j-k,x2=i+k,y2=j+k;
                if(x1<1) x1=1;
                if(y1<1) y1=1;
                if(x2>n) x2=n;
                if(y2>m) y2=m;
                mat[i-1][j-1]=dp[x2][y2]+dp[x1-1][y1-1]-dp[x1-1][y2]-dp[x2][y1-1];
            }
        }
        return mat;
    }
}
