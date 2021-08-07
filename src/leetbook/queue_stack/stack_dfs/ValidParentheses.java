package leetbook.queue_stack.stack_dfs;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * @author meteora
 */

public class ValidParentheses {
    //https://leetcode-cn.com/leetbook/read/queue-stack/g9d0h/
    public boolean validParentheses(String s) {
        //创建字符栈
        Stack<Character> stack = new Stack<>();
        //把字符串变成数组
        char[] chars = s.toCharArray();
        //数组中的每一个字符
        for (char c : chars) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if ( stack.isEmpty() || stack.pop() != c){
                // 1,如果为空,直接返回错误
                // 2,如果不为空,就要出栈
                // 如果出栈的不为该符号,也返回错误
                return false;
            }
        }
        // 如果全部成功出栈, 则true
        return stack.isEmpty();
    }


}
