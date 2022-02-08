package leetbook.DynamicPrograming.unclassified;

/**
 * LC 377
 * @author: Yihu4
 * @create: 2021-12-06 09:46
 */
public class CombinationSumIV {
    // coin change 3
    // 求排列数
    // 爬楼梯
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0]=1;
        for (int i = 1; i <= target; i++) {
            for (int j : nums) {
                if (i - j>=0){
                    dp[i]+=dp[i-j];
                }
            }
        }
        return dp[target];
    }
}
