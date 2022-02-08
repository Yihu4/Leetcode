package leetbook.array;

import java.util.Arrays;

/**
 * @author: Yihu4
 * @create: 2022-01-13 10:06
 */
public class LargestNumberAtLeastTwiceofOthers {
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int index =0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>max){
                max=nums[i];
                index=i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=max){
                if (nums[i]*2>max){
                    return -1;
                }
            }
        }
        return index;

    }
}
