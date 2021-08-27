package leetbook.array_string.doublePointer;

/**
 * LC 209
 * 大于等于目标数的最小连续子数组, 返回最小连续子数组长度
 *
 * @author: mete0ra
 * @create: 2021-08-26 15:19
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] array = new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, array));

    }

    // 滑动窗口
    // 把数组里的元素加入 current 直到达到或者超过 target, 之后减少窗口尾部的元素(目的是取得最小长度), 这样就不会遗漏
    public static int minSubArrayLen(int target, int[] nums) {
        int slow = 0;
        int fast = 0;
        int current = 0;
        int min = Integer.MAX_VALUE;
        while (fast < nums.length) {
            // 加快指针直到大于 target
            current += nums[fast++];
            // 当满足或超过目标时
            while (current >= target) {
                // 减慢指针直到小于 target
                // 因为 fast++ 所以 fast - slow 不用 + 1
                min = Math.min(min, fast - slow);
                current -= nums[slow++];
            }
        }
        return min == Integer.MAX_VALUE? 0: min;
    }
}
