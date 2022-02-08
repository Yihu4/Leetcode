package leetbook.DynamicPrograming.unclassified;

/**
 * LC 279
 * 最小需要的完全平方数数量
 * @author: Yihu4
 * @create: 2021-12-06 09:38
 */
public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                // 保存遍历的最小值
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}