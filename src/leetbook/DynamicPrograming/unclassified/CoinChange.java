package leetbook.DynamicPrograming.unclassified;

import org.junit.Test;

import java.util.Arrays;

/**
 * LC 322
 * 用coins数组里的硬币(面值不同,数量随意)
 * 返回最小等于amount所需要的硬币数
 * 如果不能满足,返回-1
 *
 * @author: Yihu4
 * @create: 2021-12-04 15:54
 */
public class CoinChange {
    @Test
    public void test() {
        int[] ints = {1,2,5};
        System.out.println(coinChangeMemo(ints, 2));
    }

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0]=0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] >amount ? -1 : dp[amount];
    }

    // 记忆化(剪枝)
    int[] memo;
    public int coinChangeMemo(int[] coins, int amount) {
        memo = new int[amount];

        return findWay(coins,amount);
    }
    // memo[n] 表示钱币n可以被换取的最少的硬币数，不能换取就为-1
    // findWay函数的目的是为了找到 amount数量的零钱可以兑换的最少硬币数量，返回其值int
    public int findWay(int[] coins,int amount){
        if(amount < 0){
            return -1;
        }
        if(amount == 0){
            return 0;
        }
        // 记忆化的处理，memo[n]用赋予了值，就不用继续下面的循环
        // 直接的返回memo[n] 的最优值
        if(memo[amount-1] != 0){
            return memo[amount-1];
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < coins.length;i++){
            int res = findWay(coins,amount-coins[i]);
            if(res >= 0 && res < min){
                min = res + 1; // 加1，是为了加上得到res结果的那个步骤中，兑换的一个硬币
            }
        }
        memo[amount-1] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount-1];
    }
}
