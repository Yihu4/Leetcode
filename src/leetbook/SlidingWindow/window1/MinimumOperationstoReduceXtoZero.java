package leetbook.SlidingWindow.window1;

import org.junit.Test;

/**
 * LC 1658
 * @author: Yihu4
 * @create: 2021-11-06 18:29
 */
public class MinimumOperationstoReduceXtoZero {
    @Test
    public void test(){
        int[] ints = {1,1};

        System.out.println(minOperations(ints, 2));
    }
    public int minOperations(int[] nums, int x) {
        // 遍历求和,再减去x,得出窗口的目标
        int sum = 0;
        for (int i : nums){
            sum += i;
        }
        int target = sum - x;
        if (target<0){
            return -1;
        }
        int left = 0;
        int cur = 0;
        int right = 0;
        int res = Integer.MAX_VALUE;
        while (right< nums.length) {
                cur+=nums[right++];
            // 如果够了
            while (cur>target){
                cur -= nums[left++];
            }
            // 如果命中,记录
            if (cur == target){
                res= Math.min(res,nums.length-(right-left));
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}
