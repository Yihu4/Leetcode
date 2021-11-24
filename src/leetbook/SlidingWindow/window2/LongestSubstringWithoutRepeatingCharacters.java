package leetbook.SlidingWindow.window2;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * LC 3
 * 最长不重复子串
 * @author: Yihu4
 * @create: 2021-11-11 20:30
 */
public class LongestSubstringWithoutRepeatingCharacters {
    @Test
    public void test(){
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int res = 0;
        HashMap<Character, Integer> table = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (table.containsKey(c)){
                left = Math.max(left,table.get(c)+1);
            }
            // 把当前的字符和下标都存入table
            table.put(c,right);
            res = Math.max(res,right -left +1);
        }
        return res;
    }
}
