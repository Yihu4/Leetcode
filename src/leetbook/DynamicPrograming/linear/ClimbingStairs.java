package leetbook.DynamicPrograming.linear;

import org.junit.Test;

/**
 * LC 70
 * @author: Yihu4
 * @create: 2021-11-14 16:24
 */
public class ClimbingStairs {
    @Test
    public void test(){
        System.out.println(climbStairs(2));
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] =1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    // 无需数组
    public int climbStairsConstant(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
