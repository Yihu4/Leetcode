package leetbook.SlidingWindow.window2;

import org.junit.Test;

/**
 * LC 487
 * @author: Yihu4
 * @create: 2021-11-12 20:37
 */
public class MaxConsecutiveOnesII {
    @Test
    public void test(){
        int[] ints = {1};
        System.out.println(findMaxConsecutiveOnesDP(ints));
    }
    //[1,0,1,1,0,1]
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int res = 0;
        int pre = 0;
        boolean flag = true;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right]==0){
                if (flag){
                    // 如果还没翻
                    flag =false;
                    // 记录位置,为了下次遇到0时充当左窗口
                    pre = right;
                }else {
                    // 如果翻过了, 上次的0位窗口的左边界
                    left = pre+1;
                    // 更新pre
                    pre = right;
                }
            }
            res = Math.max(res,right-left+1);
        }
        return res;
    }
    public int findMaxConsecutiveOnesDP(int[] nums) {
        if (nums.length==1){
            return 1;
        }
        int[][] dp = new int[nums.length][2];
        int max = 0;
        dp[0][0] = nums[0];
        dp[0][1] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]==0){
                // dp[i][0]记录当前连续的1个数
                dp[i][0]=0;
                // 遇到0时,dp[i][1]会读取dp[i-1][0]的值再+1,即假设当前为1并且加上之前连续的1
                dp[i][1]=dp[i-1][0]+1;
            }else {
                dp[i][0] = dp[i-1][0]+1;

                dp[i][1]=dp[i-1][1]+1;
            }
            max= Math.max(max,dp[i][1]);
        }
        return max;
    }
}
