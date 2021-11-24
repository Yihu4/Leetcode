package leetbook.DynamicPrograming.linear;

import java.util.Arrays;

/**
 * LC 673
 * 最长递增子序列个数
 * @author: Yihu4
 * @create: 2021-11-16 21:35
 */
public class NumberofLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        // 去除结果
        if (nums.length == 1) {
            return 1;
        }
        // 记录包括i的最长递增子序列长度,需要用maxLength来维护
        int[] dp = new int[nums.length];
        // 记录到i的最长子序列的数量
        // 在LC 300 的基础上额外维护一个count
        int[] count = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int maxLength = 0;
        for (int i = 1; i < nums.length; i++) {
            // 同LC300, 回去寻找小于当前i的j,再使当前的dp+1
            for (int j = 0; j < i; j++) {
                if (nums[j]<nums[i]){
                    // 因为要第二次判断,所以要有一个if,方便elseif
                    if (dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                        // 继承count
                        count[i] = count[j];
                    }else if (dp[j]+1==dp[i]){
                        // 这时候dp[i]已经更新了,相等等于找到重复的
                        // 加上之前的count
                        count[i]+=count[j];
                    }
                }
            }
            // 记录最大长度
            maxLength= Math.max(maxLength,dp[i]);
        }
        int res = 0;
        // 因为dp[i]的定义是包括i元素的最长递增子序列,所以如果不同下标的dp值相同, 那必定有不同的相同长度的递增子序列
        for (int i = 0; i < nums.length; i++) {
            if (dp[i]==maxLength){
                res+=count[i];
            }
        }
        return res;
    }
}
