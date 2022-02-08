package leetbook.DynamicPrograming;

import org.junit.Test;

import java.util.Arrays;

/**
 * LC 334
 * @author: Yihu4
 * @create: 2022-01-12 09:46
 */
public class IncreasingTripletSubsequence {
    @Test
    public void test(){
        int[] in = {20, 100, 10, 9, 5, 13};
        System.out.println(increasingTripletest(in));
    }
    public boolean increasingTriplet(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        //LIS
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i-1; j >=0; j--) {
                if (nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res>=3 ;
    }

    // 双向遍历
    public boolean increasingTripletDoubleTraverse(int[] nums) {
        int [] left_min = new int[nums.length];
        int [] right_max = new int[nums.length];

        // [0,i]的最小值
        left_min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            left_min[i] = Math.min(nums[i], left_min[i - 1]);
        }

        // [i,max]的最大值
        right_max[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            right_max[i] = Math.max(nums[i], right_max[i + 1]);

        }

        // 如果存在一个数大于左边区间的最小值,并且小于右边区间的最大值,就表示存在符合条件的情况
        for (int i = 1; i < nums.length - 1; i++) {
            if (left_min[i] < nums[i] && nums[i] < right_max[i])
                return true;
        }

        return false;
    }

    public boolean increasingTripletest(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if (a >= nums[i])
                a = nums[i];
            else if (b >= nums[i])
                b = nums[i];
            else
                return true;
        }
        return false;
    }
    public boolean increasingTripletBinarySearch(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res>=3;
    }

}
