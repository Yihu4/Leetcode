package leetbook.array_string.string;

import java.util.*;

/**
 * LC 151
 *
 * @author: mete0ra
 * @create: 2021-08-16 20:48
 */
public class ReverseWordsInAString {
    public static void main(String[] args) {
        System.out.println(reverseWords(" This  is a    test  "));
    }

    public static String reverseWords(String s) {
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        for (String str :
                wordList) {
            System.out.println(str);

        }
        System.out.println(wordList);
        // 翻转数组
        Collections.reverse(wordList);
        System.out.println(wordList);
        // 数组转字符串并且加上空格
        System.out.println(wordList.toString());
        String join = String.join(" ", wordList);
        System.out.println(join);
        return join;
    }

    // Deque
    public static String reverseWordsDeque(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }

        Deque<String> d = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
                // 将单词 push 到队列的头部,一次只加入一个单词
                d.offerFirst(word.toString());
                // 并且将单词字符串长度置为零
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            left++;
        }
        // 最后一个单词
        d.offerFirst(word.toString());

        return String.join(" ", d);
    }
}
