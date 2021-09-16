package leetbook.HashTable.HashMap;

import java.util.HashMap;

/**
 * LC 1
 * @author: Yihu4
 * @create: 2021-09-15 20:27
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int[] ints = twoSum(nums, 18);
        for (int i :
                ints) {
            System.out.println(i);
        }
    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];
            if (map.containsKey(a)) {
                return new int[]{i, map.get(a)};
            }
            map.put(nums[i], i);
        }
        return new int[0];

    }
}
