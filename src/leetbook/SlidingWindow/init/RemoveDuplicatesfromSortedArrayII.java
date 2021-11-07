package leetbook.SlidingWindow.init;

import org.junit.Test;

/**
 * LC 80
 * @author: Yihu4
 * @create: 2021-11-06 14:40
 */
public class RemoveDuplicatesfromSortedArrayII {
    @Test
    public void test(){
        int[] ints = {1, 2, 3, 3, 3, 3};
        removeDuplicates(ints);
    }
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length ==1){
            return nums.length;
        }
        // 第三个
        int slow = 2;
        for (int fast = 2; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow-2]){
                // slow移动的条件是fast与慢指针前第二个元素不一样
                // 这样包装了可以存在两个连续相同的值
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
