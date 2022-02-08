package leetbook.DynamicPrograming.linear;

import org.junit.Test;

/**
 * LC 91
 *
 * @author: Yihu4
 * @create: 2021-11-27 17:03
 */
public class DecodeWays {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()];
        // 如果第一个字母不为0,则一个
        if (chars[0] == '0') {
            return 0;
        }
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (chars[i] != '0') {
                if (chars[i - 1] - '0' == 1 || chars[i - 1] - '0' == 2) {
                    if (chars[i] - '0' <= 9 && chars[i] - '0' >= 7 && chars[i - 1] - '0' == 2) {
                        dp[i] = dp[i - 1];
                    } else {
                        dp[i] = dp[i - 1] + 1;
                    }
                } else {
                    dp[i] = dp[i - 1];
                }
            } else {
                if (chars[i - 1] - '0' == 1 || chars[i - 1] - '0' == 2) {
                    if (i > 1) {
                        dp[i] = dp[i - 1] - 1;
                    } else {
                        dp[i] = dp[i - 1];
                    }
                } else {
                    // 如果上一个不为1或2
                    return 0;
                }
            }
        }
        return dp[s.length() - 1];
    }
    @Test
    public void test() {
        System.out.println(numDecodingsSan("110000"));
    }
    // https://leetcode-cn.com/problems/decode-ways/solution/gong-shui-san-xie-gen-ju-shu-ju-fan-wei-ug3dd/
    // 其他细节：由于题目存在前导零，而前导零属于无效 item。可以进行特判，
    // 但个人习惯往字符串头部追加空格作为哨兵，追加空格既可以避免讨论前导零，也能使下标从 1 开始，简化 f[i-1] 等负数下标的判断。

    // https://leetcode-cn.com/problems/decode-ways/solution/jie-ma-fang-fa-tu-jie-dp-zui-qing-xi-yi-97hng/
    // 将s[i]和s[i - 1]组合起来解码（ 组合的数字范围在10 ~ 26之间 ）。如果确定了第i个数和第i - 1个数的解码方式，
    // 那么解码前i个数字和解码前i - 2个数的方案数就是相同的，即f[i] = f[i - 2]。(s[]数组下标从1开始)
    // 最后将两种决策的方案数加起来
    // 最后将两种决策的方案数加起来
    // 最后将两种决策的方案数加起来，因此，状态转移方程为： f[i] = f[i - 1] + f[i - 2]。
    public int numDecodingsSan(String s) {
        int n = s.length();
        s = " " + s;
        // 数组第一个字符为空格
        char[] cs = s.toCharArray();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            // a : 代表「当前位置」单独形成 item
            // b : 代表「当前位置」与「前一位置」共同形成 item
            int a = cs[i] - '0';
            int b = (cs[i - 1] - '0') * 10 + (cs[i] - '0');
            // 如果 a 属于有效值，那么 f[i] 可以由 f[i - 1] 转移过来
            if (1 <= a && a <= 9) f[i] = f[i - 1];
            // 如果 b 属于有效值，那么 f[i] 可以由 f[i - 2]
            if (10 <= b && b <= 26) f[i] += f[i - 2];
        }
        return f[n];
    }

    // 滚动数组
    public int numDecodingsRolling(String s) {
        int n = s.length();
        s = " " + s;
        char[] cs = s.toCharArray();
        int[] f = new int[3];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            f[i % 3] = 0;
            int a = cs[i] - '0', b = (cs[i - 1] - '0') * 10 + (cs[i] - '0');
            if (1 <= a && a <= 9) f[i % 3] = f[(i - 1) % 3];
            if (10 <= b && b <= 26) f[i % 3] += f[(i - 2) % 3];
        }
        return f[n % 3];
    }
}
