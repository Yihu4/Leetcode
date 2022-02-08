package leetbook.array_string.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * LC 5
 *
 * @author: mete0ra
 * @create: 2021-08-05 18:08
 * Manacher未看
 * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-bao-gu/
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "aabaa";
        System.out.println(longestPalindromeDPOptimize(s));
    }

    // 暴力
    public static String longestPalindromeBl(String s) {
        String res = "";
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            // <= 因为要考虑s只有一个字符的情况
            for (int j = i + 1; j <= s.length(); j++) {
                // 临时字符串,判断是不是回文
                String temp = s.substring(i, j);
                if (isPalindrome(temp) && temp.length() > max) {
                    res = temp;
                    max = temp.length();
                }
            }
        }
        return res;
    }

    public static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // 暴力优化
    public static String BlOptimize(String s) {
        int length = s.length();
        boolean[][] P = new boolean[length][length];
        int maxLen = 0;
        String maxPal = "";
        // 遍历所有的长度
        for (int len = 1; len <= length; len++) {
            for (int start = 0; start < length; start++) {
                int end = start + len - 1;
                //下标已经越界，结束本次循环
                if (end >= length) {
                    break;
                }
                //长度为 1 和 2 的单独判断下
                // P[start+1][end-1] 当前区间除去首尾如果为回文的话,比较首尾就行
                P[start][end] = (len == 1 || len == 2 || P[start + 1][end - 1]) && s.charAt(start) == s.charAt(end);
                // 如果当前为回文,并且长度超过了记录的最大长度
                if (P[start][end] && len > maxLen) {
                    maxPal = s.substring(start, end + 1);
                }
            }
        }
        return maxPal;
    }

    // 上面这种方法的dp
    public static String longestPalindromeDP(String s) {
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                // 当前状态由之前的状态转移而来
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i + 1 <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    // 上面dp一维
    public static String longestPalindromeDPOptimize(String s) {
        int n = s.length();
        String res = "";
        boolean[] P = new boolean[n];
        for (int i = n - 1; i >= 0; i--) {
            // 从尾到头,因为要用到之前的 P[j-1]
            for (int j = n - 1; j >= i; j--) {
                P[j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || P[j - 1]);
                if (P[j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }


    // DP动态规划 公共子串
    public static String dp(String s) {
        if ("".equals(s)) {
            return "";
        }
        String origin = s;
        // 字符串倒置
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[][] arr = new int[length][length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                // 一旦某个字母匹配
                if (origin.charAt(i) == reverse.charAt(j)) {
                    // 若是任一字符串的首字符匹配则为1
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        // 若是非首字母匹配,则判断两个字符串的上一个字符是否匹配,匹配则匹配长度 + 1
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                if (arr[i][j] > maxLen) {
                    int beforeRev = length - 1 - j;
                    // 判断下标是否对应
                    if (beforeRev + arr[i][j] - 1 == i) {
                        maxLen = arr[i][j];
                        //以 i 位置结尾的字符
                        maxEnd = i;
                    }
                }
            }
        }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

    // DP动态规划一维 公共子串
    public static String dp1(String s) {
        if ("".equals(s)) {
            return "";
        }
        String origin = s;
        // 字符串倒置
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[] arr = new int[length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j >= 0; j--) {
                // 一旦某个字母匹配
                if (origin.charAt(i) == reverse.charAt(j)) {
                    // 若是任一字符串的首字符匹配则为1
                    if (i == 0 || j == 0) {
                        arr[j] = 1;
                    } else {
                        // 若是非首字母匹配,则判断两个字符串的上一个字符是否匹配,匹配则匹配长度 + 1
                        arr[j] = arr[j - 1] + 1;
                    }
                } else {
                    // 不匹配则该位置零
                    arr[j] = 0;
                }
                if (arr[j] > maxLen) {
                    int beforeRev = length - 1 - j;
                    // 判断下标是否对应
                    if (beforeRev + arr[j] - 1 == i) {
                        maxLen = arr[j];
                        //以 i 位置结尾的字符
                        maxEnd = i;
                    }
                }
            }
        }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

    // 扩散中心
    public static String longestPalindromeExpandAroundCenter(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 从元素扩散
            int len1 = expandAroundCenter(s, i, i);
            // 从空隙扩散
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            // 记录最大长度以及最长回文位置
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        // 注意循环结束条件
        return R - L - 1;
    }
}
