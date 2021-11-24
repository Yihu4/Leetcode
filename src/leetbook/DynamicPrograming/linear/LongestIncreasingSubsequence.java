package leetbook.DynamicPrograming.linear;

import org.junit.Test;

import java.util.Arrays;

/**
 * LC 300
 * // 最长上升子序列
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * @author: Yihu4
 * @create: 2021-11-14 16:37
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        // dp[i],当前num[i]存在的上升序列的最长长度
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 对于每一个i,更新的值为 nums数组中i之前的值中小于当前值中, 在dp数组中的最大值+1
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            // 每次保留最大值(不用最后再遍历找最大
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    @Test
    public void test(){
        int[] ints = {7, 8, 9, 1, 2, 3, 4, 5};
        System.out.println(lengthOfLISBinarySearch(ints));
    }
    public int lengthOfLISBinarySearch(int[] nums) {
        // tails 最后的结果并不一定和正确串的值符合,但是和正确串的长度符合
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res;
    }

}