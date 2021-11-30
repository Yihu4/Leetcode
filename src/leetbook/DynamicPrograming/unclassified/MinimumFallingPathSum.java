package leetbook.DynamicPrograming.unclassified;

import org.junit.Test;

/**
 * LC 931
 * 正方形中下落路径的最小值
 *
 * @author: Yihu4
 * @create: 2021-11-29 17:49
 */
public class MinimumFallingPathSum {
    @Test
    public void test() {
        int[][] ints = {{100, -42, -46, -41}, {31, 97, 10, -10}, {-58, -51, 82, 89}, {51, 81, 69, -51}};
        System.out.println(minFallingPathSumOneDim(ints));
    }

    public int minFallingPathSum(int[][] matrix) {
        if (matrix.length == 1) {
            return matrix[0][0];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                // 上一层的那一个
                int last = matrix[i - 1][j];
                if (j > 0) {
                    last = Math.min(last, matrix[i - 1][j - 1]);
                }
                if (j < matrix.length - 1) {
                    last = Math.min(last, matrix[i - 1][j + 1]);
                }
                matrix[i][j] += last;
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            res = Math.min(res, matrix[matrix.length - 1][i]);
        }
        return res;
    }

    // 一维
    public int minFallingPathSumOneDim(int[][] matrix) {
        int m = matrix.length,n = matrix[0].length;
        int[] f = new int[n+2];
        f[0] = f[n+1] = Integer.MAX_VALUE;
        for(int j = 1; j <= n; j++) f[j] = matrix[0][j-1];
        for(int i = 1; i < m;i++){
            int temp = 0,last = Integer.MAX_VALUE;
            for(int j = 1; j <= n; j++){
                temp = f[j];
                f[j] = Math.min(Math.min(last,f[j]),f[j+1])+matrix[i][j-1];
                // 当前的存为last.方便比较
                last = temp;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j = 1; j <= n; j++) min = Math.min(min,f[j]);
        return min;
    }
}
