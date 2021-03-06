package basic;

import java.util.HashMap;

/**
 * LC 1
 *
 * @author: mete0ra
 * @create: 2021-08-26 09:39
 */
public class A1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
