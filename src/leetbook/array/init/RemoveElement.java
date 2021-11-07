package leetbook.array.init;

/**
 * LC 27
 * @author: Yihu4
 * @create: 2021-11-04 15:05
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++]= nums[fast];
            }
        }
        return slow;
    }
}
