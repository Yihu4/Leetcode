package leetbook.DynamicPrograming.unclassified;

/**
 * LC 1567
 *
 * @author: Yihu4
 * @create: 2021-11-20 16:44
 */
public class MaximumLengthofSubarrayWithPositiveProduct {
    public int getMaxLenc(int[] nums) {
        int n = nums.length;
        int[] dpZ = new int[n];
        int[] dpF = new int[n];
        if (nums[0] > 0) dpZ[0] = 1;
        else if (nums[0] < 0) dpF[0] = 1;
        int ans = dpZ[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                dpZ[i] = dpZ[i - 1] + 1;
                // 如果当前为正,那么负dp的更新规则是 上一个负dp为0那么当前还是0,如果上一个负dp有长度,那么当前长度+1
                dpF[i] = dpF[i - 1] == 0 ? 0 : dpF[i - 1] + 1;
            } else if (nums[i] < 0) {
                // 如果当前为负,那么正dp的更新规则是 上一个负dp为0那么当前还是0, 如果上一个负dp有长度,那么当前长度+1
                dpZ[i] = dpF[i - 1] == 0 ? 0 : dpF[i - 1] + 1;
                dpF[i] = dpZ[i - 1] + 1;
            } else {
                dpZ[i] = 0;
                dpF[i] = 0;
            }
            ans = Math.max(ans, dpZ[i]);
        }
        return ans;
    }

    public int getMaxLen(int[] nums) {
        int[] dpZ = new int[nums.length];
        int[] dpF = new int[nums.length];
        dpZ[0] = nums[0] > 0 ? 1 : 0;
        dpF[0] = nums[0] < 0 ? 1 : 0;
        int res = dpZ[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                dpZ[i] = dpZ[i - 1] + 1;
                dpF[i] = dpF[i - 1] == 0 ? 0 : dpF[i - 1] + 1;
            } else if (nums[i] < 0) {
                dpZ[i] = dpF[i - 1] == 0 ? 0 : dpF[i - 1] + 1;
                // 如果为负,则长度由上次的正决定
                dpF[i] = dpZ[i - 1] + 1;
            } else {
                dpZ[i] = 0;
                dpF[i] = 0;
            }
            res = Math.max(res, dpZ[i]);
        }
        return res;
    }

}
