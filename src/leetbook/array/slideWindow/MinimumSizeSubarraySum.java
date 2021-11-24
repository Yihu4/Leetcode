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
    public static int minSubArrayLen(int target, int[] nums) {
        int left =0;
        int cur = 0;
        int res = Integer.MAX_VALUE;
        for(int right = 0; right < nums.length;right++){
            cur += nums[right];
            while(cur >= target){
                res = Math.min(res,right-left +1);
                cur -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE?0:res;
    }
}
