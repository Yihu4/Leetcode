package leetbook.DynamicPrograming.unclassified;

import org.junit.Test;

/**
 * LC 343
 * n 划分n为至少2个整数,求这些整数的乘积最大值
 *
 * @author: Yihu4
 * @create: 2021-12-06 09:16
 */
public class IntegerBreak {
    @Test
    public void test() {
        System.out.println(integerBreakDP(10));
    }

    // math
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3;
        int b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        }
        if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        }
        return (int) Math.pow(3, a) * 2;
    }

    // dp
    public static int integerBreakDP(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // 两种情况
                // 将 i 拆分成 j 和 i-j 的和，且 i-j 继续拆分成多个正整数，此时的乘积是 j×dp[i−j]。
                // 将 i 拆分成 j 和 i-j 的和，且 i-j 不再拆分成多个正整数，此时的乘积是 j×(i−j)；
                // 用Math.max(dp[i],...)保留遍历最大值
                dp[i] = Math.max(dp[i], Math.max((i - j) * dp[j], (i - j) * j));
            }
        }
        return dp[n];
    }
}
