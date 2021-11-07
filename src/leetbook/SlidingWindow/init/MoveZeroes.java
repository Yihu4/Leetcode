package leetbook.SlidingWindow.init;

/**
 * LC 283
 * @author: Yihu4
 * @create: 2021-11-06 15:01
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast]!=0){
                nums[slow++] = nums[fast];
            }
        }
        for (; slow < nums.length; slow++) {
            nums[slow] = 0;
        }
    }
}
