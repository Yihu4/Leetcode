package leetbook.array_string.arrayrelati;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * LC 557
 *
 * @author: mete0ra
 * @create: 2021-08-26 20:04
 */
public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseWords2(" hahaha "));
    }

    // 栈, 效率差
    public static String reverseWords(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char ch :
                chars) {
            if (ch == ' ') {
                for (char c :
                        deque) {
                    sb.append(deque.pop());
                }
                sb.append(ch);
            } else {
                deque.push(ch);
            }
        }
        for (char c :
                deque) {
            sb.append(deque.pop());
        }
        return sb.toString();
    }

    // 局部翻转
    public static String reverseWords2(String s) {
        // 每次翻转起始位置
        int head = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 获取当前元素
            char ch = chars[i];
            // 翻转条件
            if (ch == ' ' || i == chars.length - 1) {
                int l = head;
                // 主要用于区别最后一个字符
                int r = ch == ' ' ? i - 1 : i;
                while (l < r) {
                    // 交换的同时两个指针向中间靠拢
                    char temp = chars[l];
                    chars[l++] = chars[r];
                    chars[r--] = temp;
                }
                // 在一次翻转结束后, 更新翻转起始位置
                head = i + 1;
            }

        }
        return new String(chars);
    }

}
