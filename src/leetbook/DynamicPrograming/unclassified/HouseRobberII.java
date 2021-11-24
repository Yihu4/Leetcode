package leetbook.DynamicPrograming.unclassified;

import org.junit.Test;

/**
 * LC 213
 * 打劫的房子是一个circle(首尾相连
 *
 * @author: Yihu4
 * @create: 2021-11-17 16:11
 */
public class HouseRobberII {
    @Test
    public void test(){
        int[] ints = {0,0};
        System.out.println(rob(ints));
    }
    // 如果选了第一个,就不能选最后一个
    public int rob(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        if (nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dp = new int[nums.length - 1];
        dp[0] = nums[0];
        dp[1]= Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length - 1; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        int head = dp[nums.length-2];
        dp[0] = nums[1];
        dp[1] = Math.max(nums[1],nums[2]);
        for (int i = 3,j = 2; i < nums.length; i++,j++) {
            dp[j] = Math.max(dp[j-2]+nums[i],dp[j-1]);
        }
        int res = Math.max(head,dp[nums.length-2]);
        return res;
    }
}
