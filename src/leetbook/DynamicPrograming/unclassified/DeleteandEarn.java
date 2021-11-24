package leetbook.DynamicPrograming.unclassified;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * LC 740
 * @author: Yihu4
 * @create: 2021-11-17 17:32
 */
public class DeleteandEarn {
    public int deleteAndEarn(int[] nums) {
        int size = 0;
        for (Integer i : nums) {
            size = Math.max(size, i);
        }
        if (size==1){
            return nums.length;
        }
        // 构造dp数组,每个数字的数量
        int[] arr = new int[size + 1];
        for (int num : nums) {
            arr[num]++;
        }
        int[] dp = new int[size + 1];
        dp[0] = 0;
        dp[1] = arr[1];
        for (int i = 2; i < size + 1; i++) {
            dp[i]=Math.max(dp[i-2]+arr[i]*i,dp[i-1]);
        }
        return dp[size];
    }
}
