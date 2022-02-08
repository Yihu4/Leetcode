package leetbook.DynamicPrograming.unclassified;

import org.junit.Test;

/**
 * LC 1143
 * 最长共同子序列
 *
 * @author: Yihu4
 * @create: 2021-12-04 14:59
 */
public class LongestCommonSubsequence {
    @Test
    public void test(){
        System.out.println(longestCommonSubsequence("abck", "abdc"));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        // dp[i][j] 在text1 的前i个和 text2的前j个中最长共同子序列的长度
        int[][] dp = new int[t1.length + 1][t2.length + 1];
        for (int i = 1; i <= t1.length; i++) {
            for (int j = 1; j <= t2.length; j++) {
                if (t1[i - 1] == t2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[t1.length][t2.length];
    }
}
