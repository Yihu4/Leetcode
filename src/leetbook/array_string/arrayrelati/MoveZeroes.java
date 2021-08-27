package leetbook.array_string.arrayrelati;

/**
 * LC 283
 * 把数组中的 0 移到末尾
 *
 * @author: mete0ra
 * @create: 2021-08-27 19:21
 */
public class MoveZeroes {
    public static void main(String[] args) {

    }

    // 快慢指针
    public static void moveZeroes(int[] nums) {
        int count = 0;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[current++] = nums[i];
            } else {
                count++;
            }
        }
        for (int i = nums.length - count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
