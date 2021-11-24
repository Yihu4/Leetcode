package leetbook.SlidingWindow.window2;

import org.junit.Test;

/**
 * LC 1208
 * 将s中的每个字符转为t中的字符,每次转换cost abs(t[i]-s[i]) ASCII码中的差距
 *
 * @author: Yihu4
 * @create: 2021-11-13 10:00
 */
public class GetEqualSubstringsWithinBudget {
    @Test
    public void test() {
        System.out.println(equalSubstring("abcd", "cdef", 3));
    }

    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0;
        int res = 0;
        int surplus = maxCost;
        for (int right = 0; right < s.length(); right++) {
            // 每次的差值
            int diff = Math.abs(s.charAt(right) - t.charAt(right));
            surplus -= diff;
            while (surplus<0) {
                // 如果剩余小于0
                int leftDiff = Math.abs(s.charAt(left) - t.charAt(left));
                surplus+=leftDiff;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
