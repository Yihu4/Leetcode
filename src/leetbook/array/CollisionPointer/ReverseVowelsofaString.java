package leetbook.array.CollisionPointer;

import org.junit.Test;

/**
 * LC 345
 * 1 <= s.length <= 3 * 105
 * s consist of printable ASCII characters.
 * @author: Yihu4
 * @create: 2021-11-06 10:25
 */
public class ReverseVowelsofaString {
    // 把字符存入boolean数组
    // 一些细节：由于题目没有说字符串中只包含字母，因此在使用数组模拟哈希表时，我们需要用当前字符减去 ASCII 码的最小值（空字符），而不是 'A'
    // 等于模拟整个ascii码表
    static boolean[] hash = new boolean[128];
    static char[] vowels = new char[]{'a','e','i','o','u'};
    static {
        for (char c : vowels) {
            // 元音字母的小写和大写在数组中都为true
            hash[c - ' '] = hash[Character.toUpperCase(c) - ' '] = true;
        }
    }
    public String reverseVowels(String s) {
        char[] cs = s.toCharArray();
        int n = s.length();
        int l = 0, r = n - 1;
        while (l < r) {
            if (hash[cs[l] - ' '] && hash[cs[r] - ' ']) {
                // 如果两个指针指向的都是元音字母,那么交换,交换之后指针继续前进
                char c = cs[l];
                cs[l] = cs[r];
                cs[r] = c;
                l++;
                r--;
            } else {
                // 各自判断是否符合元音字母,不符合各自前进
                if (!hash[cs[l] - ' ']) l++;
                if (!hash[cs[r] - ' ']) r--;
            }
        }
        return String.valueOf(cs);

    }
    @Test
    public void test(){
        for (boolean f :
                hash) {
            System.out.println(f);

        }
    }
}
