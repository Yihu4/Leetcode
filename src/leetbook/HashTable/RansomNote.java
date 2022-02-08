package leetbook.HashTable;

import java.util.HashMap;

/**
 * LC 383
 * ransomNote can be constructed from magazine
 *
 * @author: Yihu4
 * @create: 2021-12-04 14:46
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = magazine.toCharArray();
        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        char[] ran = ransomNote.toCharArray();
        for (char c : ran) {
            if (!map.containsKey(c) || map.get(c) <= 0) {
                return false;
            } else {
                map.put(c, map.get(c) - 1);
            }
        }
        return true;
    }

    public boolean canConstructArray(String ransomNote, String magazine) {
        int[] letter = new int[26];
        char[] chars = magazine.toCharArray();
        for (char c : chars) {
            letter[c - 'a']++;
        }
        char[] ran = ransomNote.toCharArray();
        for (char c : ran) {
            letter[c - 'a']--;
            if (letter[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
