package leetbook.DynamicPrograming.maximumSubarray;

import org.junit.Test;

/**
 * LC 53
 * @author: Yihu4
 * @create: 2021-11-15 20:42
 */
public class MaximumSubarray {
    @Test
    public void test() {
        int[] ints = {-2, 1, 3,-4 };
        System.out.println(maxSubArrayDCC(ints));
    }

    public int maxSubArrayAg(int[] nums) {
        // 定义的是包含i在内的子序列,而不是题目中要求的
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                // 因为每轮都会有记录res,所以不管加进来的是正还是负
                dp[i] =dp[i-1]+nums[i];
            }
            res  = Math.max(res,dp[i]);
        }
        return res;
    }

    // 降维/一样
    public int maxSubArrayDe(int[] nums) {
        int pre = 0;
        int res = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            res = Math.max(res, pre);
        }
        return res;
    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                // 不论当前是否小于0,先加进来,因为每一轮都有res判断
                dp[i] = dp[i - 1] + nums[i];
            } else {
                // 如果前面的小于0,就另起炉灶
                dp[i] = nums[i];
            }
            // res判断
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 贪心
    public int maxSubArrayGreedy(int[] nums) {
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result = Math.max(result, sum);
            //如果sum < 0，重新开始找子序串
            if (sum < 0) {
                sum = 0;
            }
        }
        return result;
    }

    // https://leetcode-cn.com/problems/maximum-subarray/solution/divide-and-conquer-fen-zhi-suan-fa-she-j-4sbv/
    public class tupleInfo {
        public int totalSum, leftSum, rightSum, mSum;

        public tupleInfo(int totalSum, int leftSum, int rightSum, int mSum) {
            this.totalSum = totalSum;
            this.leftSum = leftSum;
            this.rightSum = rightSum;
            this.mSum = mSum;
        }
    } //构建内部类方便传递维护的信息

    public int maxSubArrayDCC(int[] nums) {
        return maxSubArrayDC(nums, 0, nums.length - 1).mSum;
    }

    // https://leetcode-cn.com/problems/maximum-subarray/solution/divide-and-conquer-fen-zhi-suan-fa-she-j-4sbv/
    public tupleInfo maxSubArrayDC(int[] nums, int l, int r) {
        if (l == r) {
            tupleInfo t = new tupleInfo(nums[l], nums[l], nums[l], nums[l]);
            return t;
        }
        int m = (l + r) >> 1;
        tupleInfo Lt = maxSubArrayDC(nums, l, m);
        tupleInfo Rt = maxSubArrayDC(nums, m + 1, r); //递归地解决规模减小了一半的问题
        tupleInfo t = new tupleInfo(
                Lt.totalSum + Rt.totalSum,
                Math.max(Lt.leftSum, Lt.totalSum + Rt.leftSum),
                Math.max(Rt.rightSum, Rt.totalSum + Lt.rightSum),
                Math.max(Math.max(Lt.mSum, Rt.mSum), Lt.rightSum + Rt.leftSum));
        //根据子问题的信息维护原问题的信息
        return t;
    }
}
