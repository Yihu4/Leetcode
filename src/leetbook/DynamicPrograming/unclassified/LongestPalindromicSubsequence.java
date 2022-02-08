package leetbook.DynamicPrograming.unclassified;

import org.junit.Test;

/**
 * LC 516
 * subsequence 不连续
 * 寻找最长的回文subsequence
 * @author: Yihu4
 * @create: 2021-12-01 16:04
 */
public class LongestPalindromicSubsequence {
    @Test
    public void test(){
        System.out.println(longestPalindromeSubseqOneDim("bbbab"));
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            // 本身,长度为1
            f[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (chars[i] == chars[j]) {
                    // 如果首尾相同,则在去头去尾的区间的值中+2
                    f[i][j] = f[i + 1][j - 1] + 2;
                } else {
                    // 首尾不同,从f[i+1][j](去头) 和 f[i][j-1](去尾) 中找最大的
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
            }
        }
        return f[0][n - 1];
    }

    // 降维
    public int longestPalindromeSubseqOneDim(String s){
        int len=s.length();
        int longestLen=0;
        int[] dp=new int[len];
        char[] strArray=s.toCharArray();
        for(int i=len-1;i>=0;i--){//dp[i]表示s[...~i]，必选了i的最长回文子序列
            dp[i]=1;
            longestLen=0;
            for(int j=i+1;j<len;j++){
                int temp=dp[j];//相当于dp[i+1][j]
                if(strArray[i]==strArray[j]){
                    dp[j]=longestLen+2;
                }
                // 首尾不同,从f[i+1][j](去头) 和 f[i][j-1](去尾) 中找最大的
                longestLen=Math.max(longestLen,temp);//括号里的longestLen相当于dp[i][j-1]
            }

        }
        longestLen = 0;
        for (int i = 0; i < len; i++) {
            longestLen = Math.max(longestLen, dp[i]);
        }
        return longestLen;
    }
}
