package leetbook.DynamicPrograming.linear;

import org.junit.Test;

import java.util.Arrays;

/**
 * LC 354
 *
 * @author: Yihu4
 * @create: 2021-11-17 21:48
 */
public class RussianDollEnvelopes {
    @Test
    public void test(){
        int[][] ints = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        System.out.println(maxEnvelopes(ints));
    }
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[envelopes.length];
        int ans = 0;
        for (int[] env : envelopes) {
            int height = env[1];
            int left = Arrays.binarySearch(dp, 0, ans, height);
            if (left < 0) left = -left - 1;
            if (left == ans) ans++;
            dp[left] = height;
        }
        return ans;
    }

    // 转为LIS问题
    public int maxEnvelopesLIS(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp,1);
        int res = 0;
        for (int i = 0; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1]>envelopes[j][1]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            res= Math.max(res,dp[i]);
        }
        return res;
    }

}
