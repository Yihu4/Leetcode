package leetbook.DynamicPrograming.linear;

import org.junit.Test;

/**
 * LC 363
 * 返回矩阵矩形区域不超过k值的最大值
 *
 * @author: Yihu4
 * @create: 2021-12-01 19:55
 */
public class MaxSumofRectangleNoLargerThanK {
    // 朴素前缀和  O(m^2 * n^2)
    public int maxSumSubmatrixNaive(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int ans = Integer.MIN_VALUE;
        // 遍历所有区域
        // i,j为左上角坐标
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // p,q为右下角坐标
                for (int p = i; p <= m; p++) {
                    for (int q = j; q <= n; q++) {
                        int cur = sum[p][q] - sum[i - 1][q] - sum[p][j - 1] + sum[i - 1][j - 1];
                        if (cur <= k) {
                            ans = Math.max(ans, cur);
                        }
                    }
                }
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int[] ints = {4, 3, -1, -7, -9, 6, 2, -7};
        System.out.println(dpmax(ints, 5));
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
        // O(cols ^ 2 * rows)
        for (int l = 0; l < cols; l++) { // 枚举左边界
            int[] rowSum = new int[rows]; // 左边界改变才算区域的重新开始
            for (int r = l; r < cols; r++) { // 枚举右边界
                for (int i = 0; i < rows; i++) { // 按每一行累计到 dp
                    rowSum[i] += matrix[i][r];
                }
                max = Math.max(max, dpmax(rowSum, k));
                if (max == k) return k; // 尽量提前
            }
        }
        return max;
    }

    // https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/solution/javacong-bao-li-kai-shi-you-hua-pei-tu-pei-zhu-shi/
    // 求连续的数组相加  小于等于k的最大值
    private int dpmax(int[] arr, int k) {
        int rollSum = arr[0], rollMax = rollSum;
        // O(rows)
        // 滚动最大值
        for (int i = 1; i < arr.length; i++) {
            if (rollSum > 0) {
                rollSum += arr[i];
            } else {
                rollSum = arr[i];
            }
            if (rollSum > rollMax) {
                rollMax = rollSum;
            }
        }
        if (rollMax <= k) return rollMax;
        // O(rows ^ 2)
        // 如果上面的方法找不到,只能暴力求
        int max = Integer.MIN_VALUE;
        for (int l = 0; l < arr.length; l++) {
            int sum = 0;
            for (int r = l; r < arr.length; r++) {
                sum += arr[r];
                // 更新
                if (sum > max && sum <= k) {
                    max = sum;
                }
                if (max == k) {
                    return k;
                } // 尽量提前
            }
        }
        return max;
    }
}
