package leetbook.DynamicPrograming.unclassified;

import org.junit.Test;

/**
 * LC 392
 * 判断s是否是t的子序列
 * s和t都可以为空
 *
 * @author: Yihu4
 * @create: 2021-12-03 11:57
 */

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        // 从后往前dp
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                // 根据f[i][j]的定义: 从位置i开始,字符j出现的第一个位置
                // 如果t中i位置的字符就是j,那么从位置i开始,字符j出现的第一个位置就是i本身
                if (t.charAt(i) == j + 'a')
                    f[i][j] = i;
                else
                    // 如果不是本身,那么就在之后
                    f[i][j] = f[i + 1][j];
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            // 如果f[i][j]中没有下一个出现的字母,直接返回false
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            // 更新位置,更新到s中下个字母在t中的位置
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(isSubsequence("axc", "addbddc"));
    }

    public boolean isSubsequenceDoublePointer(String s, String t) {
        char[] chars = s.toCharArray();
        char[] target = t.toCharArray();
        int slow = 0;
        int fast = 0;
        while (slow < chars.length && fast < target.length) {
            if (chars[slow] == target[fast]) {
                slow++;
            }
            fast++;
        }
        return slow == chars.length;
    }

}
