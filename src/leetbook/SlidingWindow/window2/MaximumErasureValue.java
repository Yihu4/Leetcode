package leetbook.SlidingWindow.window2;

import org.junit.Test;

import java.util.HashMap;

/**
 * LC 1695
 * 删除连续子数组,使删除的和最大
 * @author: Yihu4
 * @create: 2021-11-11 20:54
 */
public class MaximumErasureValue {
    @Test
    public void test(){
        int[] nums = {4,2,4,5,6};
        System.out.println(maximumUniqueSubarray(nums));
    }
    public int maximumUniqueSubarray(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int left = -1;
        int cur = 0;
        int res = 0;
        for (int right = 0; right < nums.length; right++) {
            int i = nums[right];
            if (map.containsKey(i)){
                // 更新窗口左边界
                if (map.get(i)>=left){
                    for (int j = left+1; j <= map.get(i); j++) {
                        cur-= nums[j];
                    }
                    left = map.get(i);
                }
            }
            cur +=nums[right];
            res = Math.max(res,cur);
            map.put(i,right);
        }
        return res;
    }
}
