package leetbook.array_string.arrayrelati;

import java.util.Arrays;

/**
 * LC 26
 * 数组原地去重
 * 返回数组长度
 *
 * @author: mete0ra
 * @create: 2021-08-27 10:54
 */
public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        int[] ints = {1,1,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(ints));
        System.out.println(Arrays.toString(ints));
    }

    public static int removeDuplicates(int[] nums) {
        // 第一个元素不用改
        int current = 0;
        for (int i = 1; i < nums.length; i++) {
            // 往下直到找到不同的
            if (nums[i] != nums[current]) {
                // 找到不同则指针+ 1 并修改数组为不同只
                nums[++current] = nums[i];
            }
        }
        return current + 1;
    }
    public int removeDuplicatesNew(int[] nums) {
        int slow = 0;
        int fast = 1;
        while(fast<nums.length){
            if(nums[fast]!=nums[slow]){
                nums[++slow]=nums[fast];
            }
            fast++;
        }
        return slow+1;
    }
}
