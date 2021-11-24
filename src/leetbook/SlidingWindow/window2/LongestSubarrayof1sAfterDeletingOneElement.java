package leetbook.SlidingWindow.window2;

/**
 * LC 1493
 * 删除一个(必须),获取最大连续1长度
 * @author: Yihu4
 * @create: 2021-11-13 10:51
 */
public class LongestSubarrayof1sAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int flag = 1;
        int res = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                flag--;
            }
            while (flag < 0) {
                if (nums[left] == 0) {
                    flag++;
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res - 1;
    }

    public int longestSubarrayDP(int[] nums) {
        int len = nums.length;
        int res = 0;
        // 连续1
        int count = 0;
        int extendCount = 0;
        if (nums[0] == 1) count = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] == 0) {
                // 当前是 0，删除自己(继承目前连续1的数量count)
                extendCount = count;
                // 连续1置零
                count = 0;
            } else {
                count++;
                extendCount++;
            }
            res = Math.max(res, extendCount);
        }
        return res;
    }

}
