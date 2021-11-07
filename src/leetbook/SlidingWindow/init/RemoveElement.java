package leetbook.SlidingWindow.init;

/**
 * LC 27
 *
 * @author: Yihu4
 * @create: 2021-11-06 14:35
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            if (nums[r] != val) {
                nums[l++] = nums[r];
            }
            r++;
        }
        return l;
    }
}
