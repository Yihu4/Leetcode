package leetbook.array_string.string;

import java.util.Arrays;

/**
 * LC 28
 *
 * @author: mete0ra
 * @create: 2021-08-17 20:53
 * https://leetcode-cn.com/problems/implement-strstr/solution/shua-chuan-lc-shuang-bai-po-su-jie-fa-km-tb86/
 */
public class StrStrXXX {
    public static void main(String[] args) {
        System.out.println(KMP("aaacbaab","aaaba"));

    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        char[] hay = haystack.toCharArray();
        char[] need = needle.toCharArray();
        int m = haystack.length();
        int n = needle.length();
        for (int i = 0; i < m; i++) {
            int a = i;
            int b = 0;
            while (hay[a] == need[0]) {
                a++;
                b++;
            }
            // 如果匹配串的长度等于needle串的长度, 则返回i, 即发起点的下标
            if (b == n) {
                return i;
            }
        }
        return -1;
    }

    // KMP
    public static int KMP(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        // 分别读取原串和匹配串的长度
        int n = haystack.length(), m = needle.length();
        // 原串和匹配串前面都加空格，使其下标从 1 开始
        haystack = " " + haystack;
        needle = " " + needle;

        char[] s = haystack.toCharArray();
        char[] p = needle.toCharArray();
        System.out.println(Arrays.toString(s));
        System.out.println(Arrays.toString(p));
        // 构建 next 数组，数组长度为匹配串的长度（next 数组是和匹配串相关的）
        int[] next = new int[m + 1];
        // 构造过程 i = 2，j = 0 开始，i 小于等于匹配串长度 【构造 i 从 2 开始】(next[0]和next[1]都为0)
        for (int i = 2, j = 0; i <= m; i++) {
            // 匹配不成功的话，j = next[j], 不断往前
            while (j > 0 && p[i] != p[j + 1]) {
                j = next[j];
            }
            // 匹配成功的话，先让 j++, 然后赋值, 即next[i]为当前j下标+1
            if (p[i] == p[j + 1]) {
                j++;
            }
            // 更新 next[i]，结束本次循环，i++
            next[i] = j;
        }
        System.out.println(Arrays.toString(next));

        // 匹配过程，i = 1，j = 0 开始，i 小于等于原串长度 【匹配 i 从 1 开始】
        for (int i = 1, j = 0; i <= n; i++) {
            // 匹配不成功 j = next(j)
            while (j > 0 && s[i] != p[j + 1]) {
                j = next[j];
            }
            // 匹配成功的话，先让 j++，结束本次循环后 i++
            if (s[i] == p[j + 1]) {
                j++;
            }
            // 整一段匹配成功，直接返回下标
            if (j == m) {
                return i - m;
            }
        }

        return -1;

    }
}