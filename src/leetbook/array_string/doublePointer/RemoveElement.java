package leetbook.array_string.doublePointer;

import java.util.Arrays;

/**
 * LC 27
 *
 * @author: mete0ra
 * @create: 2021-08-25 15:11
 * https://leetcode-cn.com/leetbook/read/array-and-string/cv3bv/
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 3, 2, 2, 4};
        System.out.println(removeElement(arr, 2));
        System.out.println(Arrays.toString(arr));
    }
    // 快慢指针
    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int slow = 0;
        for (int fast = 0; fast < n; fast++) {
            if (nums[fast] != val) {
                // 不相等
                nums[slow] = nums[fast];
                slow++;
            }
            System.out.println(Arrays.toString(nums));
        }
        return slow;
    }
}
