package basic;

// LC322 Coin Change

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 *  https://leetcode-cn.com/problems/coin-change/solution/javadi-gui-ji-yi-hua-sou-suo-dong-tai-gui-hua-by-s/
 * @author meteora
 */

public class B322CoinChange {


    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        System.out.println(dp(coins, 2));
    }

    static int res = Integer.MAX_VALUE;

    /**
     * dfs
     */
    public static int coinChangeDfs(int[] coins, int amount) {
        // check
        if (coins.length == 0) {
            return -1;
        }
        dfs(coins, amount, 0);
        // 如果没有任何硬币能组合返回 -1
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }


    public static void dfs(int[] coins, int amount, int count) {
        if (amount < 0) {
            return;
        }
        if (amount == 0) {
            res = Math.min(res, count);
        }
        for (int coin : coins) {
            dfs(coins, amount - coin, count + 1);
        }
    }

    /**
     * memo 记忆化
     * 自上向下
     */
    static int[] memo;

    public static int coinChangeMemo(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        memo = new int[amount];

        return memory(coins, amount);
    }

    /**
     * memo[n] 表示钱币n可以被换取的最少的硬币数，不能换取就为-1
     * findWay函数的目的是为了找到 amount数量的零钱可以兑换的最少硬币数量，返回其值int
     */
    public static int memory(int[] coins, int amount) {
        // 如果相减小于0, 返回-1(即无效)
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        // 记忆化的处理，memo[n]中如果赋予了值，就不用继续执行下面的语句
        // 直接的返回memo[n] 的最优值
        if (memo[amount - 1] != 0) {
            return memo[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = memory(coins, amount - coin);
            // res < min 的作用是找出需要硬币数量更少的组合
            if (res >= 0 && res < min) {
                // 加1，是为了加上得到res结果的那个步骤中增加的一个硬币
                min = res + 1;
            }
        }
        // 如果没有匹配的最小值(即min还是Integer.MAX_VALUE 那么min为-1
        memo[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount - 1];
    }

    /**
     * 动态规划
     * 自下而上
     */

    public static int dp(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        // memo[n] 表示凑n需要的最少硬币数
        memo = new int[amount + 1];
        // 数组所有元素都填充amount+1
        Arrays.fill(memo, amount + 1);
        memo[0] = 0;
        for (int i = 1; i <= amount ; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    memo[i] = Math.min(memo[i], memo[i - coin] + 1);
                }
            }
        }

        // 如果memo[amount]里面的值没改变, 即还是amount+1, 则没有路径
        return memo[amount] == (amount+1) ? -1 : memo[amount];
    }

}
