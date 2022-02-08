package leetbook.HashTable.HashSet;

import org.junit.Test;

import java.util.HashMap;

/**
 * LC 219
 * @author: Yihu4
 * @create: 2022-01-19 17:15
 */
public class ContainsDuplicateII {
    @Test
    public void test(){
        int[] ints = {1, 2, 3, 1, 2, 3};
        System.out.println(containsNearbyDuplicateHashMap(ints, 2));
    }

    public boolean containsNearbyDuplicateHashMap(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 如果出现过
            if (map.containsKey(nums[i])){
                Integer pre = map.get(nums[i]);
                if (pre!=i&&pre>=i-k){
                    return true;
                }
            }
            map.put(nums[i],i);
        }
        return false;
    }

    public boolean containsNearbyDuplicateForce(int[] nums, int k) {
        if (k==0){
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <= i+k; j++) {
                if (j==nums.length){
                    break;
                }
                if (nums[j]==nums[i]){
                    return true;
                }
            }
        }
        return false;
    }


}
