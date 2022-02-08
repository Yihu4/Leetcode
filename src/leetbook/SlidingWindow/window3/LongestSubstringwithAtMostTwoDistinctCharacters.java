package leetbook.SlidingWindow.window3;

import java.util.HashMap;
import java.util.HashSet;

/**
 * LC 159
 * 找到最多包含两个不同字符的子串
 * @author: Yihu4
 * @create: 2021-12-01 21:07
 */
public class LongestSubstringwithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int res = 0;
        HashSet<Character> set = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < chars.length; right++) {
            if (map.containsKey(chars[right])){
                map.put(chars[right],map.get(chars[right])+1);
            }else {
                map.put(chars[right],1);
            }
            if (map.size()>2){
                map.put(chars[left],map.get(chars[left])-1);
                if (map.get(chars[left])==0){
                    map.remove(chars[left]);
                }
                left++;
            }
            res = right-left+1;
        }
        return res;
    }
}
