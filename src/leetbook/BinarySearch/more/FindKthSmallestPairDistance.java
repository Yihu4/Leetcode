package leetbook.BinarySearch.more;

import org.junit.Test;

import java.util.Arrays;

/**
 * LC 719
 * @author: Yihu4
 * @create: 2021-10-31 18:22
 */
public class FindKthSmallestPairDistance {
    @Test
    public void test(){
        int[] ints={1,3,4,11,12,28,30};
        System.out.println(smallestDistancePair(ints, 7));
    }
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = nums[n - 1] - nums[0];
        while(left < right){
            int mid = (left + right) / 2;
            if(getCount(mid, nums) < k){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    // 比dis小的距离数量
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
