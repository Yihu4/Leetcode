package leetbook.DynamicPrograming.linear;

/**
 * LC 338
 *
 * @author: Yihu4
 * @create: 2021-12-10 15:23
 */
public class CountingBits {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        // 根据发现的规律

        for (int i = 0; i <= n; i++) {
            if (i % 2 == 1) {
                // 奇数的二进制中1的个数比 比它小1的数多1
                dp[i] = dp[i - 1] + 1;
            } else {
                // 偶数的二进制中1的个数 跟 他二分之一的数一样
                dp[i] = dp[i / 2];
            }
        }
        return dp;
    }
}
