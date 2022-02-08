package leetbook.DynamicPrograming;

import org.junit.Test;

import java.util.*;

/**
 * LC 472
 * 输出可以被其他字符串组成的string
 *
 * @author: Yihu4
 * @create: 2021-12-28 17:12
 */
public class ConcatenatedWords {
    @Test
    public void test() {
        String[] strings = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        System.out.println(findAllConcatenatedWordsInADict(strings));
    }

    Set<Long> set = new HashSet<>();
    // 素数减少哈希碰撞
    int P = 131, OFFSET = 128;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        for (String s : words) {
            long hash = 0;
            for (char c : s.toCharArray()) {
                // 对每个string进行哈希处理
                hash = hash * P + (c - 'a') + OFFSET;
            }
            // 加入set
            set.add(hash);
        }
        List<String> ans = new ArrayList<>();
        for (String s : words) {
            // 检查当前字符串是否符合
            if (check(s)) {
                ans.add(s);
            }
        }
        return ans;
    }

    boolean check(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        Arrays.fill(f, -1);
        f[0] = 0;
        for (int i = 0; i <= n; i++) {
            if (f[i] == -1) {
                continue;
            }
            long cur = 0;
            for (int j = i + 1; j <= n; j++) {
                // 计算string中i到j的字符串的哈希值
                cur = cur * P + (s.charAt(j - 1) - 'a') + OFFSET;
                // 从i到j这个区间内如果有string符合,那么f[j]的单词数就在f[i]的基础上+1
                if (set.contains(cur)) {
                    f[j] = Math.max(f[j], f[i] + 1);
                }
            }
            if (f[n] > 1) {
                return true;
            }
        }
        return false;
    }
}
