package leetbook.BinarySearch.more;

import org.junit.Test;

import java.util.Arrays;

/**
 * LC 410
 *
 * @author: Yihu4
 * @create: 2021-11-03 21:05
 */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int max = 0;
        int sum = 0;

        // 计算「子数组各自的和的最大值」的上下界
        for (int num : nums) {
            // 下界为数组中的最大值, 因为完全切割的话
            max = Math.max(max, num);
            // m=1
            sum += num;
        }

        // 使用「二分查找」确定一个恰当的「子数组各自的和的最大值」，
        // 使得它对应的「子数组的分割数」恰好等于 m
        int left = max;
        int right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int splits = split(nums, mid);
            if (splits > m) {
                // 如果分割数太多，说明「子数组各自的和的最大值」太小，需要增大
                // 下一轮搜索的区间是 [mid + 1, right]
                left = mid + 1;
            } else {
                // 下一轮搜索的区间是上一轮的反面区间 [left, mid]
                right = mid;
            }
        }
        return left;
    }

    /***
     *
     * @param nums 原始数组
     * @param maxIntervalSum 子数组各自的和的最大值
     * @return 满足不超过「子数组各自的和的最大值」的分割数
     */
    // 满足当前[子数组各自的和的最大值]的分割数
    private int split(int[] nums, int maxIntervalSum) {
        // 至少是一个分割
        int splits = 1;
        // 当前区间的和
        int curIntervalSum = 0;
        for (int num : nums) {
            // 尝试加上当前遍历的这个数，如果加上去超过了「子数组各自的和的最大值」，就不加这个数，另起炉灶
            if (curIntervalSum + num > maxIntervalSum) {
                curIntervalSum = 0;
                splits++;
            }
            curIntervalSum += num;
        }
        return splits;
    }

    @Test
    public void test() {
        int[] ints = {7, 2, 5, 10, 8};
        System.out.println(splitArrayDP(ints, 3));
    }

    // DP
    public int splitArrayDP(int[] nums, int m) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            // 前缀和
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        for (int i = 0; i <= m; i++) {
            // 数组全取最大值
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= n; j++) {
                for (int k = 0; k < j; k++) {// 必须从0开始,因为[1][1]需要k=0
                    // k是分割点
                    // max里面是分割后,两个数组的比较
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][k], preSum[j] - preSum[k]));
                }
            }
        }
        return dp[m][n];
    }

}
