package leetbook.SlidingWindow.window2;

import org.junit.Test;

/**
 * LC 76
 *
 * @author: Yihu4
 * @create: 2021-11-10 09:12
 */
public class MinimumWindowSubstring {
    @Test
    public void test() {
        String s = "a";
        String t = "b";
        System.out.println(minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        // 如果t为0, 或者s的长度小于t的长度
        if (t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        // ASCII表数组
        int[] ints = new int[128];
        // 存入t字符串中的每个字符
        for (int i = 0; i < t.length(); i++) {
            ints[t.charAt(i)]++;
        }
        int left = 0;
        int count = t.length();
        int start = 0;
        int size = Integer.MAX_VALUE;
        for (int right = 0; right < s.length(); right++) {
            if (ints[s.charAt(right)] > 0) {
                // 满足包含条件
                count--;
            }
            // 类似栈,入栈
            ints[s.charAt(right)]--;
            while (count == 0) {
                // 全部包含, 满足条件
                if (right - left + 1 < size) {
                    // 如果size更新,获取当前的起点与size
                    size = right - left + 1;
                    start = left;
                }
                // 处理窗口左边界, 出栈
                ints[s.charAt(left)]++;
                if (ints[s.charAt(left)] > 0) {
                    count++;
                }
                left++;
            }
        }
        // 如果不符合条件, size还是Integer.MAX_VALUE
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }
}
