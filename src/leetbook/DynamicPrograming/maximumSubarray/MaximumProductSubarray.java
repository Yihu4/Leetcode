package leetbook.DynamicPrograming.maximumSubarray;

import org.junit.Test;

/**
 * LC 152
 *
 * @author: Yihu4
 * @create: 2021-11-20 15:20
 */
public class MaximumProductSubarray {
    @Test
    public void test() {
        int[] ints = {2, -3, -2, 4, -4};
        System.out.println(maxProduct(ints));
    }

    // https://leetcode-cn.com/problems/maximum-product-subarray/solution/cheng-ji-zui-da-zi-shu-zu-tu-jie-dpzui-q-jjzv/
    public int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][2];
        int res = nums[0];
        // 包括当前元素序列的最小数
        dp[0][0] = nums[0];
        // 包括当前元素序列的最大数
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 每一步计算当前的最大/最小
            // 比较dp[i-1][0]乘以当前  和dp[i-1][1]乘以当前的大小    再和目前的元素进行比较
            dp[i][0] = Math.min(nums[i], Math.min(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]));
            dp[i][1] = Math.max(nums[i], Math.max(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]));
            // 每一步记录最大值
            res = Math.max(res, dp[i][1]);
        }
        return res;
    }
}
