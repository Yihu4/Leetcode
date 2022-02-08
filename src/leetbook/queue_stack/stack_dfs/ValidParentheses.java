package leetbook.queue_stack.stack_dfs;

import java.util.Stack;

/**
 * LC 20
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * @author meteora
 */

public class ValidParentheses {
    //https://leetcode-cn.com/leetbook/read/queue-stack/g9d0h/
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                // 注意要判断栈为空
                return false;
            }
        }
        // 如果栈为空,则返回正确
        return stack.isEmpty();
    }
}
