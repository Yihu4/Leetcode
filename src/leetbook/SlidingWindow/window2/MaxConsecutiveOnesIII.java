package leetbook.SlidingWindow.window2;

/**
 * LC 1004
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * k个可替换的0
 *
 * @author: Yihu4
 * @create: 2021-11-13 09:04
 */
public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int count = k;
        int left = 0;
        int res = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                count--;
            }
            if (count < 0) {
                // 如果0多了, 处理窗口左边界(右移)
                if (nums[left] == 0) {
                    // 如果右移剔除的是0, 那么count+1
                    count++;
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public int longestOnesBinarySearch(int[] nums, int k) {
        int n = nums.length;
        int[] P = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            // 前缀和,当前下标+1之前的0个数
            P[i] = P[i - 1] + (1 - nums[i - 1]);
        }

        int ans = 0;
        for (int right = 0; right < n; ++right) {
            int left = binarySearch(P, P[right + 1] - k);
            // 找到当前right 满足条件的left边界
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }

    public int binarySearch(int[] P, int target) {
        int low = 0, high = P.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (P[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}
