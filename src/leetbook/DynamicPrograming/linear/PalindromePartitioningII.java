package leetbook.DynamicPrograming.linear;

import org.junit.Test;

/**
 * LC 132
 *
 * @author: Yihu4
 * @create: 2021-12-08 20:21
 */
public class PalindromePartitioningII {
    @Test
    public void test() {
        System.out.println(minCutAg("aabacaba"));
    }

    public int minCut(String s) {
        int n = s.length();
        char[] charArray = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (charArray[i] == charArray[j] && (j - i <= 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }

        // f[r]代表s[0,r]的最少分割次数
        int[] f = new int[n];
        for (int r = 1; r < n; r++) {
            // 如果 [0,r] 满足回文，不需要分割
            if (dp[0][r]) {
                f[r] = 0;
            } else {
                // 先设f[r]为最大分割次数r
                f[r] = r;
                // 在所有符合 [0,r] 回文的方案[l,r]中取最小值
                for (int l = 0; l < r; l++) {
                    //[0,r]都已经判断过，从[1,r]开始依次判断
                    if (dp[l + 1][r]) {
                        f[r] = Math.min(f[r], f[l] + 1);
                    }
                }
            }
        }

        return f[n - 1];
    }

    public int minCutAg(String s) {
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[chars.length][chars.length];
        for (int right = 0; right < chars.length; right++) {
            for (int left = 0; left <= right; left++) {
                if (chars[left] == chars[right] && (right - left <= 1 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }
        // dpp[i]表示到chars[i]达成条件的最小分割数
        int[] f = new int[chars.length];
        for (int right = 1; right < chars.length; right++) {
            if (dp[0][right]) {
                f[right] = 0;
            } else {
                // 先假设分割数
                f[right] = f[right - 1] + 1;
                // 寻找更小分割数
                for (int left = 0; left < right; left++) {
                    // LIS思路,如果其中有回文,则长度为f[left]+1,保留期间最小
                    if (dp[left + 1][right]) {
                        f[right] = Math.min(f[right], f[left] + 1);
                    }
                }
            }
        }
        return f[chars.length - 1];
    }
}
