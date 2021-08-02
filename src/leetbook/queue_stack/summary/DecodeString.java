package leetbook.queue_stack.summary;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// LC394字符串解码
// 用栈是方便解决嵌套的'['
// https://leetcode-cn.com/problems/decode-string/solution/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/
public class DecodeString {
    public static void main(String[] args) {
        //char a = '1';
        //System.out.println(10 - a + '0');
        //StringBuilder b = new StringBuilder();
        //char c = 'b';
        //b.append(c);
        //System.out.println(b);

        System.out.println(Arrays.toString(dfs("2[ac]ac", 0)));
    }

    // 数字栈和 字幕栈分别记录, 遇到 '[' 和 ']' 入栈和出栈
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Deque<Integer> multiStack = new ArrayDeque<>();
        Deque<StringBuilder> resStack = new ArrayDeque<>();
        int multi = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                multi = multi * 10 + c - '0';
            } else if (c == '[') {
                // 入栈
                // 遇到 '[' 则把之前的一个结果存入resStack
                resStack.push(res);
                res = new StringBuilder();
                // 把 '[' 之前的一个数字存入numStack, 再置零
                multiStack.push(multi);
                multi = 0;
            } else if (c == ']') {
                // 出栈
                StringBuilder pre = resStack.pop();
                int n = multiStack.pop();
                // 该区间的字母乘以数字
                for (int i = 0; i < n; i++) {
                    pre.append(res);
                }
                res = pre;
            } else {
                // 字符, 延长当前的字符串
                res.append(c);
            }
        }
        return res.toString();
    }

    // dfs递归
    private static String[] dfs(String s, int i) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        while (i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                // Integer.parseInt 把字符串转换为int
                // String.valueOf 把变量转换为字符串
                multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
            } else if (s.charAt(i) == '[') {
                // tmp[0]为最新的索引i
                // tmp[1]为此 '[......]'区间内字符串
                String[] tmp = dfs(s, i + 1);
                i = Integer.parseInt(tmp[0]);
                // res + multi * tmp 拼接字符串
                while (multi > 0) {
                    res.append(tmp[1]);
                    multi--;
                }
            } else if (s.charAt(i) == ']') {
                // 只在递归中才会遇到 ']' , 返回 ']' 的位置, 出递归之后i++会进入 ']'的下一个元素
                return new String[]{String.valueOf(i), res.toString()};
            } else {
                // 字符串, StringBuilder 可以直接append字符,无需String.valueOf
                res.append(String.valueOf(s.charAt(i)));
            }
            i++;
        }
        return new String[]{res.toString()};

    }

}
