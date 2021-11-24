package leetbook.SlidingWindow.window2.pro;

import org.junit.Test;

import java.util.*;

/**
 * LC 727
 * 找出s1中包含s2(顺序)的最小子序列
 *
 * @author: Yihu4
 * @create: 2021-11-16 09:21
 */
public class MinimumWindowSubsequence {
    @Test
    public void test() {
        String s = "abcddbede";
        String t = "bde";
        System.out.println(minWindowDP(s, t));
    }

    public String minWindow(String s1, String s2) {
        int s2Idx = 0;
        // 子串长度
        int length = Integer.MAX_VALUE;
        String res = "";
        for (int right = 0; right < s1.length(); right++) {
            if (s1.charAt(right) == s2.charAt(s2Idx)) {
                s2Idx++;
            }
            // 如果找完了所有的s2字符
            if (s2Idx == s2.length()) {
                // 记录当前right位置,准备左缩
                int cur = right;
                while (s2Idx != 0) {
                    if (s1.charAt(right) == s2.charAt(s2Idx - 1)) {
                        s2Idx--;
                    }
                    // 注意是right往左缩
                    // 可能出现[a,b,c,d,d,b,e,d,e]这种,如果right不往左缩,会遗漏掉bede而选择bcddbe
                    right--;
                }
                right++;
                if (cur - right + 1 < length) {
                    length = cur - right + 1;
                    res = s1.substring(right, cur + 1);
                }
            }
        }
        return res;
    }

    // DP(next数组)
    public String minWindowDP(String S, String T) {
        int N = S.length();
        // 存每个字符出现的最早位置
        int[] last = new int[26];
        // 每个下标之后所有字符出现的第一个位置
        int[][] next = new int[N][26];
        Arrays.fill(last, -1);

        /*for (int i = N - 1; i >= 0; --i) {
            // 存每个字符出现的最早位置
            last[S.charAt(i) - 'a'] = i;
            for (int k = 0; k < 26; ++k) {
                // 每个下标之后所有字符出现的第一个位置
                next[i][k] = last[k];
            }
        }*/
        for (int i = S.length() - 1; i >= 0; i--) {
            last[S.charAt(i) - 'a'] = i;
            for (int j = 0; j < 26; j++) {
                next[i][j] = last[j];
            }
        }

        List<int[]> windows = new ArrayList();
        for (int i = 0; i < N; ++i) {
            // 找到S中每一个 T的开头
            if (S.charAt(i) == T.charAt(0))
                windows.add(new int[]{i, i});
        }
        for (int j = 1; j < T.length(); ++j) {
            int letterIndex = T.charAt(j) - 'a';
            for (int[] window : windows) {
                // 如果没越界, 并且下一个T的字符在next数组中存在(>=0)
                if (window[1] < N - 1 && next[window[1] + 1][letterIndex] >= 0) {
                    // 更新窗口(区间)右边界
                    window[1] = next[window[1] + 1][letterIndex];
                } else {
                    // 如果不存在 舍弃这个区间
                    window[0] = window[1] = -1;
                    break;
                }
            }
        }


        int[] ans = {-1, S.length()};
        for (int[] window : windows) {
            if (window[0] == -1) break;
            if (window[1] - window[0] < ans[1] - ans[0]) {
                ans = window;
            }

        }
        return ans[0] >= 0 ? S.substring(ans[0], ans[1] + 1) : "";
    }


    // 冗余 O(N^2)
    public String minWindow1(String s1, String s2) {
        char[] s1char = s1.toCharArray();
        char[] s2char = s2.toCharArray();
        String res = "";
        int s1Len = s1.length();
        int s2Len = s2.length();
        if (s1Len < s2Len) return res;

        int minLen = Integer.MAX_VALUE;
        int l = 0, r = 0;
        while (r < s1Len) {

            while (check1(s1char, l, r, s2char, 0, s2Len - 1)) {
                // 找到了缩
                l++;
                if (r - l + 1 < minLen) {
                    res = s1.substring(l - 1, r + 1);
                    minLen = r - l + 1;
                }
            }
            r++;
        }
        return res;
    }

    public boolean check1(char[] s, int sl, int sr, char[] t, int tl, int tr) {
        // 如果s窗口小于t窗口
        if (sr - sl < tr - tl) return false;
        int sIndex = sl;
        int tIndex = tl;
        // check的是[sl,sr] 和 [tl,tr]
        while (sIndex <= sr && tIndex <= tr) {
            if (s[sIndex] == t[tIndex]) {
                // 如果对应一个,则t的对比下标+1
                tIndex++;
            }
            // 无论是否找到,s下标+1
            sIndex++;
        }
        // 如果超过,说明对比成功
        return tIndex > tr;
    }

}
