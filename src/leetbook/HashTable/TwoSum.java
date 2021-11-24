package leetbook.HashTable;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: Yihu4
 * @create: 2021-11-16 20:23
 */
public class TwoSum {
    @Test
    public void test(){
        int[] ints = {3,2,4};
        System.out.println(Arrays.toString(twoSum(ints, 6)));

    }
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i< nums.length;i++){
            if (map.containsKey(target-nums[i])){
                    return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }

}
