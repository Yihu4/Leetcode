package leetbook.array_string;

import org.junit.Test;

/**
 * LC 408
 *
 * @author: Yihu4
 * @create: 2021-12-09 16:32
 */
public class ValidWordAbbreviation {
    @Test
    public void test() {
        System.out.println(validWordAbbreviationLC("apple", "1"));
    }

    public boolean validWordAbbreviation(String word, String abbr) {
        char[] source = word.toCharArray();
        char[] target = abbr.toCharArray();
        if (target[0] - '0' == 0) {
            return false;
        }
        int fast = 0;
        int cur = 0;
        for (int slow = 0; slow < target.length; slow++) {
            int number = target[slow] - '0';
            if (number >= 0 && number <= 9) {
                // 如果是0开头的
                if (cur == 0 && number == 0) {
                    return false;
                }
                cur = cur * 10 + number;
            } else {
                // 如果不是数字
                fast += cur;
                if (fast > source.length - 1) {
                    return false;
                }
                if (source[fast] != target[slow]) {
                    return false;
                }
                fast++;
                cur = 0;
            }
        }
        return fast+cur ==source.length;
    }

    public boolean validWordAbbreviationLC(String word, String abbr) {
        char[] chars = abbr.toCharArray();
        int num = 0;    // 缩写中的数字，不能出现前导0
        int next = 0;   // 遍历 chars 的指针
        for (char c : chars) {
            // 如果是数字，则拼接成最后的样子
            if (c >= '0' && c <= '9') {
                // 前导0数字不合法
                if (num == 0 && c == '0') return false;
                num = num * 10 + (c - '0');
                continue;
            }

            next = next + num;  // 更新指针
            // 如果 next 超出了 word 的长度，说明不是 word 的缩写
            // 或者，如果 word 和 abbr 在 next 位置的字符不一致，则说明不是 word 的缩写
            if (next >= word.length() || (word.charAt(next) != c)) {
                return false;
            }
            next++;
            num = 0;
        }
        return next + num == word.length();
    }
}
