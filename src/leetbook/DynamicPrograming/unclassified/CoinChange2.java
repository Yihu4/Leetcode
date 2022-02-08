package leetbook.DynamicPrograming.unclassified;

import org.junit.Test;

/**
 * LC 518
 * 返回路径数
 *
 * @author: Yihu4
 * @create: 2021-12-04 16:48
 */
public class CoinChange2 {
    @Test
    public void test() {
        int[] ints = {1, 2, 5};
        System.out.println(changeOneDim(11, ints));
    }

    // 但是当你运行之后，却发现这个代码并不正确，得到的结果比预期的大。究其原因，该代码计算的结果是 排列数，而不是 组合数，
    // 也就是代码会把 1,2和 2,1 当做两种情况。但更加根本的原因是我们子问题定义出现了错误。
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= amount; i++) {
            for (int j : coins) {
                if (i - j >= 0) {
                    dp[i] += dp[i - j];
                }
            }
        }
        return dp[amount];
    }

    // https://leetcode-cn.com/problems/coin-change-2/solution/hua-tu-li-jie-cong-chang-gui-er-wei-dpda-4gfy/
    public int changeTwoDim(int amount, int[] coins) {
        // dp[i][j] 使用i个硬币,达成j amount的方案数
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                // 由没有该硬币的方案  加  有该硬币的此前方案 转换而来
                dp[i][j] = dp[i - 1][j] + (j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }

    public int changeOneDim(int amount, int[] coins) {
        int []dp = new int[amount+1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}
