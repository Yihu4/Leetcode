package leetbook.SlidingWindow.init;

/**
 * LC 674
 *
 * @author: Yihu4
 * @create: 2021-11-06 14:27
 */
public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length==1){
            return 1;
        }
        int l = 0;
        int r = 1;
        int res = 0;
        while (r < nums.length) {
            if (nums[r-1]>=nums[r]){
                l = r;
            }
            res= Math.max(res,r-l+1);
            r++;
        }
        return res;
    }
}
