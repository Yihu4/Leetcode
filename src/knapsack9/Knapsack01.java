package knapsack9;
/**
 * 01背包问题
 *
 * f[i][j]表示只看前i个物品, 总体积是j的情况下, 总价值最大是多少
 *
 * result = max{f[n][0-v]}
 * 结果为n件物品, 在0-v的体积中的最大值
 *
 *      不选当前dp[i-1][j]
 *      选当前物品dp[i-1][j-weight[i]] + value[i]
 *
 */

public class Knapsack01 {
}
