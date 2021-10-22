package leetbook.HashTable.HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * LC387
 *
 * @author: Yihu4
 * @create: 2021-09-23 20:33
 */
public class FirstUniqueCharacterinaString {
    public static void main(String[] args) {
        firstUniqChar("leetcode");
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (frequency.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
