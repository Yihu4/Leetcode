package leetbook.DynamicPrograming.unclassified;

import org.junit.Test;

/**
 * LC 55
 * @author: Yihu4
 * @create: 2021-11-18 15:57
 */
public class JumpGame {
    @Test
    public void test(){
        int[] nums = {2,3,1,1,4};
        System.out.println(canJumpAlter(nums));
    }
    public boolean canJump(int[] nums) {
        if (nums.length==1){
            return true;
        }
        if (nums[0]==0){
            return false;
        }
        int[] dp = new int[nums.length - 1];
        dp[0]=nums[0];
        for (int i = 1; i < nums.length-1; i++) {
            if (dp[i-1]<i){
                return false;
            }
            dp[i] = Math.max(dp[i-1],i+nums[i]);
        }

        if (dp[nums.length-2]>=nums.length-1){
            return true;
        }
        return false;
    }

    public boolean canJumpAlter(int[] nums) {
        if (nums.length==1){
            return true;
        }
        if (nums[0]==0){
            return false;
        }
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 每次检查上次是否到得了当前下标
            if (dp[i-1]<i){
                return false;
            }
            dp[i] = Math.max(dp[i-1],i+nums[i]);
        }
        return true;
    }
    public boolean canJumpLC(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) return false;
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }
}
