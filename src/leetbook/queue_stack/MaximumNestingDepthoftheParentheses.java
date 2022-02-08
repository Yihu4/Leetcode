package leetbook.queue_stack;

import java.util.Stack;

/**
 * LC 1614
 * @author: Yihu4
 * @create: 2022-01-07 11:06
 */
public class MaximumNestingDepthoftheParentheses {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='('){
                stack.push(')');
            }
            if (chars[i]==')'){
                stack.pop();
            }
            max = Math.max(max,stack.size());
        }
        return max;
    }
}
