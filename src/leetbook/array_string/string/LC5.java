package leetbook.array_string.string;

import org.junit.Test;

/**
 * Longest Palindromic Substring
 *
 * @author: Yihu4
 * @create: 2021-12-01 11:38
 */
public class LC5 {
    // dp
    public String longestPalindromeDP(String s) {
        String res = "";
        boolean[] dp = new boolean[s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = s.length() - 1; j >= i; j--) {
                // 通过dp[j-1](即上一次i的循环确定的i+1到j-1位置是否回文) && 这一次的首尾来判断这一次的 i到j位置是否为回文
                dp[j] = s.charAt(i) == s.charAt(j) && (j - i + 1 <= 2 || dp[j - 1]);
                // 如果是回文, 并且长度大于记录长度,更新res
                if (dp[j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(longestPalindrome("aabaa"));
    }

    // 扩散中心
    public String longestPalindrome(String s) {
        String res = "";
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expendAroundCenter(s, i, i);
            int len2 = expendAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > res.length()) {
                res = s.substring(i-(len-1)/2,i+len/2+1);
            }
        }
        return res;
    }

    private int expendAroundCenter(String s, int left, int right) {
        int L = left;
        int R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
