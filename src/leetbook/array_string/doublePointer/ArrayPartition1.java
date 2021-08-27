package leetbook.array_string.doublePointer;

import java.util.Arrays;

/**
 * LC 561
 * @author: mete0ra
 * @create: 2021-08-25 08:58
 */
public class ArrayPartition1 {
    public static void main(String[] args) {

    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i+=2) {
            res += nums[i];
        }
        return res;
    }
}
