package leetbook.HashTable;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * LC 1044
 *
 * @author: Yihu4
 * @create: 2021-12-23 19:21
 */
public class LongestDuplicateSubstring {
    @Test
    public void test() {
        System.out.println(longestDupSubstring("banana"));
    }

    long[] h, p;

    public String longestDupSubstring(String s) {
        int P = 1313131;
        int n = s.length();
        h = new long[n + 10];
        p = new long[n + 10];
        p[0] = 1;
        for (int i = 0; i < n; i++) {
            p[i + 1] = p[i] * P;
            h[i + 1] = h[i] * P + s.charAt(i);
        }
        String ans = "";
        int l = 0, r = n;
        while (l < r) {
            // 对长度进行二分
            int mid = l + r + 1 >> 1;
            String t = check(s, mid);
            // 找得到就增大
            if (t.length() != 0) {
                l = mid;
            } else {
                // 找不到就缩小
                r = mid - 1;
            }
            // 如果当前的长度大于目前的ans,则更新ans
            ans = t.length() > ans.length() ? t : ans;
        }
        return ans;
    }

    String check(String s, int len) {
        int n = s.length();
        // 为当前长度建立哈希
        Set<Long> set = new HashSet<>();
        // 以当前长度遍历字符串
        for (int i = 1; i + len - 1 <= n; i++) {
            int j = i + len - 1;
            long cur = h[j] - h[i - 1] * p[j - i + 1];
            // 如果当前长度哈希包含,则返回当前区间字符串
            if (set.contains(cur)) {
                return s.substring(i - 1, j);
            }
            set.add(cur);
        }
        return "";
    }
}
