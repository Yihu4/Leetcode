package leetbook.DynamicPrograming.maximumSubarray;

import org.junit.Test;

/**
 * LC 918
 * @author: Yihu4
 * @create: 2021-11-19 19:38
 */
// https://leetcode-cn.com/problems/maximum-sum-circular-subarray/solution/python3-huan-xing-shu-zu-qiu-zi-shu-zu-z-gyjf/
// 图
public class MaximumSumCircularSubarray {
    @Test
    public void test(){
        int[] ints = {3, -1, 4, -4, -5, 6, 7, -8, 5};
        System.out.println(maxSubarraySumCircular(ints));
    }

    // 比较连续最大子序列的值         和         总和减去连续最小序列的值
    public int maxSubarraySumCircular(int[] A) {
        int dp = A[0];      //初始化
        int max = dp;                //最大子序列和
        int sum = dp;                //整个数组的和

        // 求最大子序列和，见53题
        for (int i = 1; i < A.length; i++) {
            sum += A[i];
            dp = A[i] + Math.max(dp, 0);
            max = Math.max(dp, max);
        }

        int min = 0;
        dp = A[0];
        for (int i = 1; i < A.length - 1; i++) {
            dp = A[i] + Math.min(0, dp);
            min = Math.min(dp, min);
        }

        return Math.max(sum - min, max);
    }
}
