package leetbook.array_string.doublePointer;

/**
 * LC 485
 * 二进制数组, 求出连续 1 个数
 *
 * @author: mete0ra
 * @create: 2021-08-26 10:02
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {

    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int slow = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                slow = i + 1;
            }else {
                max=Math.max(i - slow + 1, max);
            }
        }
        return max;
    }
    // https://leetcode-cn.com/problems/max-consecutive-ones/solution/zui-da-lian-xu-1de-ge-shu-by-leetcode-so-252a/
    public static int lC(int[] nums) {
        int current = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                current++;
            }else {
                max = Math.max(current, max);
                current=0;
            }
        }
        // 结尾的时候要再判断一次
        max = Math.max(current, max);
        return max;
    }
}
