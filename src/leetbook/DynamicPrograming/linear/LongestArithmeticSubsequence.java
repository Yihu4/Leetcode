package leetbook.DynamicPrograming.linear;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 1027
 * 求数组中最长等差数列的长度
 *
 * @author: Yihu4
 * @create: 2021-12-02 20:14
 */
public class LongestArithmeticSubsequence {
    @Test
    public void test() {
        int[] ints = {2,3,4};
        System.out.println(longestArithSeqLengthLC(ints));
    }

    // 错误
    public int longestArithSeqLength(int[] nums) {
        int N = nums.length;

        Map<Integer, Integer> map = new HashMap();
        int res = 0;
        // dp[i][j]以nums[i] 和 nums[j]结尾的最长子序列
        int[][] dp = new int[N - 1][N];
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = 2;
            }
        }

        // 以nums[j] nums[i]结尾的最长等差数列
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < i; ++j) {
                int target = 2 * nums[j] - nums[i];
                if (map.containsKey(target)) {
                    dp[j][i] = dp[map.get(target)][j] + 1;
                    res = Math.max(res, dp[j][i]);
                }
                map.put(nums[j], j);
            }
        }
        return res >= 3 ? res : 2;
    }

    public int longestArithSeqLengthLC(int[] nums) {
            int len = nums.length;
            int[][] dp = new int[len - 1][len];
            for (int i = 0; i < len - 1; i++) {
                for (int j = 0; j < len; j++) {
                    dp[i][j] = 2;
                }
            }
            Map<Integer, Integer> map = new HashMap<>();
            int max = 0;
            for (int i = 0; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    // 找以nums[i] nums[j]结尾的最长等差序列
                    int target = 2 * nums[i] - nums[j];
                    if (map.containsKey(target)) {
                        // 如果包括
                        // 获取以nums[t] nums[i]结尾的最长等差子序列
                        // 再加1, 因为 nums[t] nums[i] nums[j]的长度多1
                        dp[i][j] = dp[map.get(target)][i] + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
                // 当[i][j]结束时,更新当前i
                map.put(nums[i], i);
            }
            return max;
    }
}
