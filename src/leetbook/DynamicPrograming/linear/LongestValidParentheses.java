package leetbook.DynamicPrograming.linear;

import org.junit.Test;

import java.util.Stack;

/**
 * LC 32
 *
 * @author: Yihu4
 * @create: 2021-12-06 19:33
 */
public class LongestValidParentheses {
    @Test
    public void test() {
        System.out.println(longestValidParenthesesDP("((()()))()"));
    }

    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.add(i);
            } else {
                if (!st.isEmpty()) {
                    st.pop();
                    if (st.isEmpty()) {
                        ans = Math.max(ans, i - start + 1);
                    } else {
                        ans = Math.max(ans, i - st.peek());
                    }
                } else {
                    start = i + 1;
                }
            }
        }
        return ans;
    }

    // dp
    public int longestValidParenthesesDP(String s) {
        // 以s[i]结尾的长度
        int[] dp = new int[s.length()];
        if (s.length() < 2) return 0;
        int maxL = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
            }
            maxL = Math.max(maxL, dp[i]);
        }
        return maxL;
    }

}
