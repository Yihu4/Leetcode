package leetbook.array_string;

import java.util.HashMap;

/**
 * LC 383
 * @author: Yihu4
 * @create: 2021-11-20 14:50
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            if (map.containsKey(magazine.charAt(i))){
                map.put(magazine.charAt(i),map.get(magazine.charAt(i))+1);
            }else {
                map.put(magazine.charAt(i),1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (!map.containsKey(ransomNote.charAt(i))||map.get(ransomNote.charAt(i))==0){
                return false;
            }
            if (map.containsKey(ransomNote.charAt(i))){
                map.put(ransomNote.charAt(i),map.get(ransomNote.charAt(i))-1);
            }
        }
        return true;
    }

    public boolean canConstructLetter(String ransomNote, String magazine) {
        int[] array = new int[26];
        for (char ch : magazine.toCharArray()) {
            array[ch - 'a']++;
        }
        // 合二为一
        for (char ch : ransomNote.toCharArray()) {
            if (--array[ch - 'a'] < 0)
                return false;
        }
        return true;
    }

}
