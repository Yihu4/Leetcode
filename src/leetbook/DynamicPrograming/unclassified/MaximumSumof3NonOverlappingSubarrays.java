package leetbook.DynamicPrograming.unclassified;

import org.junit.Test;

import java.util.ArrayList;

/**
 * LC 689
 * 找出长度为k的,三个不重叠子串,返回每个子串的开始下标
 *
 * @author: Yihu4
 * @create: 2021-12-08 09:53
 * Input: nums = [1,2,1,2,6,7,5,1], k = 2
 * Output: [0,3,5]
 * <p>
 * Input: nums = [1,2,1,2,1,2,1,2,1], k = 2
 * Output: [0,2,4]
 */
public class MaximumSumof3NonOverlappingSubarrays {
    @Test
    public void test() {
        int[] ints = {1, 2, 1, 2, 6, 7, 5, 1};
        maxSumOfThreeSubarraysReverse(ints, 2);
    }

    // 反序DP
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        // 前缀和
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        // 定义 f[i][j] 为考虑前 i 个数，凑成无重叠子数组数量为 j 个时的最大值。
        // 反转dp,考虑倒数前i个数
        long[][] f = new long[n + 10][4];
        for (int i = n - k + 1; i >= 1; i--) {
            for (int j = 1; j < 4; j++) {
                f[i][j] = Math.max(f[i + 1][j], f[i + k][j - 1] + sum[i + k - 1] - sum[i - 1]);
            }
        }
        int[] ans = new int[3];
        int i = 1, j = 3, idx = 0;
        while (j > 0) {
            if (f[i + 1][j] > f[i + k][j - 1] + sum[i + k - 1] - sum[i - 1]) {
                i++;
            } else {
                ans[idx++] = i - 1;
                i += k;
                j--;
            }
        }
        return ans;
    }

    // 翻转数组,两种方法本质一样
    public int[] maxSumOfThreeSubarraysReverse(int[] nums, int k) {
        int n = nums.length;
        reverse(nums);
        // 前缀和
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        long[][] f = new long[n + 10][4];
        for (int i = k; i <= n; i++) {
            for (int j = 1; j < 4; j++) {
                // 两种情况
                // 没取当前nums,依旧是之前的f[i][j]
                // 取了当前nums,f[i-k][j-1]+区间和
                f[i][j] = Math.max(f[i - 1][j], f[i - k][j - 1] + sum[i] - sum[i - k]);
            }
        }
        int[] ans = new int[3];
        int i = n, j = 3, idx = 0;
        while (j > 0) {
            // 没取当前
            if (f[i - 1][j] > f[i - k][j - 1] + sum[i] - sum[i - k]) {
                // 继续
                i--;
            } else {
                // 取了当前
                ans[idx++] = n - i;
                i -= k;
                j--;
            }
        }
        return ans;
    }
    void reverse(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int c = nums[l];
            nums[l++] = nums[r];
            nums[r--] = c;
        }
    }
}
