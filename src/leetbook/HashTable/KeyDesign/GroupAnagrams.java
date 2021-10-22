package leetbook.HashTable.KeyDesign;

import java.util.*;

/**
 * LC 49
 * @author: Yihu4
 * @create: 2021-09-24 19:11
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            // 每个相同组成的通过排列会变成一样
            Arrays.sort(array);
            // 转为 String
            String key = new String(array);
            // 获取相同组成数组
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            // 往数组中加入当前字符串
            list.add(str);
            // 加入 hashmap 集合
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
