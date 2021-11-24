package leetbook.array_string;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * LC 242
 * @author: Yihu4
 * @create: 2021-11-20 15:06
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else {
                map.put(s.charAt(i),1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),map.get(t.charAt(i))-1);
            }
            if (!map.containsKey(t.charAt(i))){
                return false;
            }
        }
        for (int i : map.values()) {
            if (i!=0){
                return false;
            }
        }
        return true;
    }
}
