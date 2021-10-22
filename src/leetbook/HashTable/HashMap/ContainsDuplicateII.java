package leetbook.HashTable.HashMap;

import java.util.HashMap;

/**
 * LC 219
 * @author: Yihu4
 * @create: 2021-09-24 17:31
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 如果遇到重复
            if (map.containsKey(nums[i])){
                // 比较
                if ((i-map.get(nums[i]))<=k){
                    return true;
                }else {
                    map.put(nums[i],i);
                }
            }else {
                // 存入当前的
                map.put(nums[i],i);
            }
        }
        return false;
    }
}
