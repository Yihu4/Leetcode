package leetbook.array.slideWindow;

import org.junit.Test;

/**
 * LC 209
 * target = 7, nums = [2,3,1,2,4,3]
 * return 2
 * 返回大于或等于target的最小连续
 * @author: Yihu4
 * @create: 2021-11-06 11:23
 */
public class MinimumSizeSubarraySum {
    @Test
    public void test(){
        int[] ints = {2, 3, 1, 2, 4, 3};
        minSubArrayLen(7,ints);

    }
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;
        int cur = nums[0];
        int res = Integer.MAX_VALUE;
        while (r < nums.length){
            if (cur<target){
                if (r==nums.length-1){
                    break;
                }
                // 如果不满足目标,则扩大窗口右边界
                cur+=nums[++r];
            }else {
                // 当前窗口大小r -l + 1
                res = Math.min(res,r- l + 1);
                // 如果满足目标,则缩小窗口左边界
                cur-=nums[l++];
            }
        }
        return res == Integer.MAX_VALUE? 0: res;
    }
}
