package leetbook.DynamicPrograming.linear;

import org.junit.Test;

/**
 * LC 813
 *
 * @author: Yihu4
 * @create: 2022-01-04 20:05
 */

public class LargestSumofAverages {
    @Test
    public void test() {
        int[] ints = {9, 1, 2, 3, 9};
        System.out.println(largestSumOfAverages(ints, 3));
    }

    // https://leetcode-cn.com/problems/largest-sum-of-averages/solution/dong-tai-gui-hua-xiang-jie-by-wang-nmana-v1vk/
    public double largestSumOfAverages(int[] nums, int k) {
        int[] pre = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        // dp[i][j] 前i个数,分成k份的最大要求值
        double[][] dp = new double[nums.length + 1][k + 1];
        for (int i = 1; i <= nums.length; i++) {
            // 处理分割数为1的情况
            dp[i][1] = (double) pre[i] / i;
            for (int K = 2; K <= k; K++) {
                for (int j = 0; j < i; j++) {
                    // 在所有分割情况中寻找最大的
                    // 从前j个数的 当前分割数-1 的状态转移而来  i-j的这一段区间为新增的分割
                    dp[i][K] = Math.max(dp[i][K], dp[j][K - 1] + (double) (pre[i] - pre[j]) / (i - j));
                }
            }

        }
        return dp[nums.length][k];
    }

    double[] sum;//前缀和
    double[][] memo;//记忆化数组 double[i][j]表示nums的[0, i]被分成j份的最大分配方案的对应值
    public double largestSumOfAveragesDFS(int[] nums, int k) {
        int n = nums.length;
        sum = new double[n + 1];
        for (int i = 1; i <= n; ++i) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        memo = new double[n][k + 1];
        return dfs(nums, 0, k);
    }

    double dfs(int[] nums, int i, int p) {
        if (memo[i][p] != 0.0) {
            return memo[i][p];
        }
        int n = nums.length;
        if (p == 1) {
            return (sum[n] - sum[i]) / (n - i);
        }

        //枚举分割点j，j将[i, n - 1]分为两部份
        //前半部分[i,j-1]作为单独的分组，后半部分[j, n-1]作为剩下的p-1组
        //则有 n - 1 - j + 1 >= p - 1  --> j <= n - p + 1;
        double temp = 0;
        for (int j = i + 1; j <= n - p + 1; ++j) {
            double part1 = (sum[j] - sum[i]) / (j - i);
            double part2 = dfs(nums, j, p - 1);
            temp = Math.max(temp, part2 + part1);
        }
        memo[i][p] = temp;
        return temp;
    }
}
