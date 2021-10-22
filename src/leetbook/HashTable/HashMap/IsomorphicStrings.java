package leetbook.HashTable.HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * LC205
 * @author: Yihu4
 * @create: 2021-09-17 17:05
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        /*String s = "sofjip12";
        String s1 = String.valueOf(s.charAt(1));
        Map<Object, Integer> map = new HashMap<>();
        Integer a = map.put('a', 1);
        System.out.println(a);
        Integer a1 = map.put("a", 2);
        System.out.println(a1);*/

    }
    // 要互相验证, 双向验证, 不然会漏
    public boolean isIsomorphic(String s, String t) {
        Map<Object, Integer> map = new HashMap<>();
        for (Integer i = 0; i < s.length(); i++) {
            // put 方法返回的是旧值,如果没有旧值,则返回 null
            // 分别是字符和字符串, 等于是创造了两个 map
            if (map.put(s.charAt(i), i)!=map.put(String.valueOf(t.charAt(i)), i)) {
                return false;
            }
        }
        return true;
    }

    // 双向验证
    public boolean isIsomorphic1(String s, String t) {
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);

    }

    private boolean isIsomorphicHelper(String s, String t) {
        int n = s.length();
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                map.put(c1, c2);
            }
        }
        return true;
    }


}
