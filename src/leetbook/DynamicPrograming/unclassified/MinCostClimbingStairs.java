package leetbook.DynamicPrograming.unclassified;

/**
 * LC 746
 * @author: Yihu4
 * @create: 2021-11-16 17:58
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0]=0;
        dp[1]=Math.min(cost[0],cost[1]);
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i-2]+cost[i-1],dp[i-1]+cost[i]);
        }
        return dp[cost.length-1];
    }

    public int minCostClimbingStairsOp(int[] cost) {
        int dp0=0;
        int dp1=Math.min(cost[0],cost[1]);
        int dp = 0;
        for (int i = 2; i < cost.length; i++) {
            dp = Math.min(dp0+cost[i-1],dp1+cost[i]);
            dp0=dp1;
            dp1=dp;
        }
        return dp;
    }

    // 滚动数组
    public int minCostClimbingStairsRolling(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] = Math.min(cost[i - 2], cost[i - 1]) + cost[i];
        }
        return Math.min(cost[cost.length - 2], cost[cost.length - 1]);
    }

}
