package leetbook.DynamicPrograming.linear;

import org.junit.Test;

/**
 * LC 198
 * 不能抢相邻的房间
 *
 * @author: Yihu4
 * @create: 2021-11-17 15:53
 */
public class HouseRobber {
    @Test
    public void test() {
        int[] ints = {1, 2, 3, 1};
        System.out.println(rob(ints));
    }

    // 转移方程
    // dp[i]取决于   dp[i-2]加上当前的   或者 dp[i-1]的最大值
    public int rob(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    // 优化
    public int robOptimize(int[] nums) {
        int prePre = 0;
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = Math.max(prePre+nums[i],pre);
            prePre= pre;
            pre=tmp;
        }
        return pre;
    }
}
