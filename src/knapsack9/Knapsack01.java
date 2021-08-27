package knapsack9;

import java.util.HashMap;
import java.util.Map;

/**
 * 01背包问题
 * <p>
 * f[i][j]表示只看前i个物品, 总体积是j的情况下, 总价值最大是多少
 * <p>
 * result = max{f[n][0-v]}
 * 结果为n件物品, 在0-v的体积中的最大值
 * <p>
 * 不选当前dp[i-1][j]
 * 选当前物品dp[i-1][j-weight[i]] + value[i]
 * @author meteora
 */


public class Knapsack01 {
    // 最大价值
    static int max = 0;
    // 承重量
    static int m = 3;

    public static void main(String[] args) {
        int[] w = {1, 1, 3};
        int[] v = {2, 2, 5};
        dfsmemo(w, v, 0, 0, 0);
        System.out.println(max);
    }

    // 暴搜dfs
    private static void dfs(int[] w, int[] v, int index, int currentValue, int currentWeight) {
        // 边界
        if (index == w.length) {
            if (currentWeight <= m && max < currentValue) {
                max = currentValue;
            }
            return;
        }
        // 选
        dfs(w, v, index + 1, currentValue + v[index], currentWeight + w[index]);
        // 不选
        dfs(w, v, index + 1, currentValue, currentWeight);
    }
    // 以当前位置index 和当前重量currentWeight作为记忆化的维度
    static boolean[][] memo = new boolean[4][999];
    private static void dfsmemo(int[] w, int[] v, int index, int currentWeight, int currentValue) {

        if (memo[index][currentWeight]) {
            return;
        }
        memo[index][currentWeight] = true;
        // 边界
        if (index == w.length) {
            if (currentWeight <= m && max < currentValue) {
                max = currentValue;
            }
            return;
        }
        // 选
        dfsmemo(w, v, index + 1, currentWeight + w[index], currentValue + v[index]);
        // 不选
        dfsmemo(w, v, index + 1, currentWeight, currentValue);
    }


    public static int dp(int m, int[] w, int[] v) {
        int[][] dp = new int[w.length + 1][m + 1];
        for (int i = 1; i <= w.length; i++) {
            for (int j = 1; j <= m; j++) {
                if (j >= w[i - 1]) {
                    // w[i - 1] 和 v[i - 1]是因为i和j是从1开始的
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[w.length][m];
    }

    public static int dpRoll(int m, int[] w, int[] v) {
        int[][] dp = new int[2][m + 1];
        for (int i = 1; i <= w.length; i++) {
            for (int j = 1; j <= m; j++) {
                if (j >= w[i - 1]) {
                    // 遇到列 i 则 % 2
                    dp[i % 2][j] = Math.max(dp[(i - 1) % 2][j], dp[(i - 1) % 2][j - w[i - 1]] + v[i - 1]);
                } else {
                    dp[i % 2][j] = dp[(i - 1) % 2][j];
                }
            }
        }
        return dp[w.length % 2][m];
    }

    public static int dp1(int m, int[] w, int[] v) {
        int[] dp = new int[m + 1];
        for (int i = 1; i <= w.length; i++) {
            for (int j = m; j >= 1; j--) {
                if (j >= w[i - 1]) {
                    // w[i - 1] 和 v[i - 1]是因为i和j是从1开始的
                    dp[j] = Math.max(dp[j], dp[j - w[i - 1]] + v[i - 1]);
                } else {
                    // 没有else了, 因为不用更改
                }
            }
        }
        return dp[m];
    }
}
