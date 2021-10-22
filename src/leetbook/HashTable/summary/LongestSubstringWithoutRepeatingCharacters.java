package leetbook.HashTable.summary;

import java.util.HashMap;
import java.util.HashSet;

/**
 * LC 3
 * 字符串最长 不重复 子串
 *
 * @author: Yihu4
 * @create: 2021-10-12 17:12
 * "dvdw"
 * "pwwkew"
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        lengthOfLongestSubstring("abba");
    }

    // 滑动窗口
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            // 对每个字符进行处理
            if (map.containsKey(s.charAt(i))) {
                // 如果包括则通过字符获取下标, 更新左窗口边界
                // 因为可能有不同字符的重复,不能确定重复的是哪一个字符,所以要比较 left 和重复元素下标
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            // 存入 HashMap 按照下标, 不管包不包含
            map.put(s.charAt(i), i);
            // 更新 max 值
            max = Math.max(max, i - left + 1);
        }
        return max;

    }
}
