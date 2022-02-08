package leetbook.array_string;

import org.junit.Test;

/**
 * LC 686
 *
 * @author: Yihu4
 * @create: 2021-12-22 20:29
 */
public class RepeatedStringMatch {
    @Test
    public void test(){
        System.out.println(repeatedStringMatch("ab", "baba"));
    }
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        while (sb.length() < b.length()) {
            sb.append(a);
            ans++;
        }
        sb.append(a);
        // 被包含的起始位置
        int idx = sb.indexOf(b);
        if (idx == -1) {
            return -1;
        }
        // 如果起始位置+b长度大于当前,则次数+1
        if (idx + b.length() > a.length() * ans) {
            ans++;
        }
        return ans;
    }
}
