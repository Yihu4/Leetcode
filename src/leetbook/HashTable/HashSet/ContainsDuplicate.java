package leetbook.HashTable.HashSet;

import java.util.HashSet;

/**
 * LC 217
 *
 * @author: Yihu4
 * @create: 2021-09-14 19:33
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet hashSet = new HashSet<Integer>();
        for (int num :
                nums) {
            if (hashSet.contains(num)) {
                return true;
            }
            hashSet.add(num);
        }
        return false;
    }

    public boolean containsDuplicateLc(int[] nums) {
        HashSet hashSet = new HashSet<Integer>();
        for (int num : nums) {
            // hashset add 方法如果重复会返回 false
            if (!hashSet.add(num)) {
                return true;
            }
        }
        return false;
    }
}
