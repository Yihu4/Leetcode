package leetbook.BinarySearch.more;

import java.util.Arrays;

/**
 * LC 719
 * @author: Yihu4
 * @create: 2021-10-31 18:22
 */
public class FindKthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = nums[n - 1] - nums[0];
        while(left <= right){
            int mid = (left + right) / 2;
            if(getCount(mid, nums) < k){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }

    private int getCount(int dis, int[] nums){
        int l = 0, cnt = 0;
        for(int r = 0; r < nums.length; r++){
            while(nums[r] - nums[l] > dis){
                l++;
            }
            cnt += r - l;
        }
        return cnt;
    }

}
