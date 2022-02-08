package leetbook.DynamicPrograming.unclassified;

import org.junit.Test;

import java.util.Arrays;

/**
 * LC 376
 *
 * @author: Yihu4
 * @create: 2021-12-03 10:49
 */
public class WiggleSubsequence {
    @Test
    public void test() {
        int[] ints = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        System.out.println(wiggleMaxLengthOptimize(ints));
    }

    // DP
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        // dp[i][0],以nums[i]结尾,并且为下降的最长子序列长度
        // dp[i][1],以nums[i]结尾,并且为上升的最长子序列长度
        int[][] dp = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
        }
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 下降
                if (nums[i] - nums[j] < 0) {
                    //
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                }
                // 上升
                if (nums[i] - nums[j] > 0) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                }
            }
            res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
        }
        return res;
    }

    public int wiggleMaxLengthOptimize(int[] nums) {
        // dp[i][0],数组中下降的最长子序列长度
        // dp[i][1],数组中上升的最长子序列长度
        int[][] dp = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            // 下降
            dp[i][0] = dp[i - 1][0];
            if (nums[i] - nums[i - 1] < 0) {
                dp[i][0] = dp[i - 1][1] + 1;
            }
            // 上升
            dp[i][1] = dp[i - 1][1];
            if (nums[i] - nums[i - 1] > 0) {
                dp[i][1] = dp[i - 1][0] + 1;
            }
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

    // https://leetcode-cn.com/problems/wiggle-subsequence/solution/tan-xin-si-lu-qing-xi-er-zheng-que-de-ti-jie-by-lg/
    // 贪心
    public int wiggleMaxLengthLC(int[] nums) {
        int down = 1, up = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                up = down + 1;
            else if (nums[i] < nums[i - 1])
                down = up + 1;
        }
        return Math.max(down, up);
    }
}
