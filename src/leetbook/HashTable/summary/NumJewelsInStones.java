package leetbook.HashTable.summary;

import java.util.HashMap;
import java.util.HashSet;

/**
 * LC 771
 * @author: Yihu4
 * @create: 2021-10-12 16:34
 */
public class NumJewelsInStones {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        char[] chars = jewels.toCharArray();
        for (Character ch :
                chars) {
            set.add(ch);
        }
        char[] chars1 = stones.toCharArray();
        for (Character ch :
                chars1) {
            if (set.contains(ch)){
                count++;
            }
        }
        return count;
    }
}
