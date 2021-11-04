package leetbook.BinarySearch.template3;

/**
 * LC 162
 * 找任何一个峰
 * 左右元素不相等
 * @author: Yihu4
 * @create: 2021-10-26 20:09
 */
public class FindPeakElement {
    // 模板2
    public int findPeakElement2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + right >> 1;
            if (nums[mid] > nums[mid + 1]){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 模板3
    public int findPeakElement3(int[] nums) {
        int left = 0 , right=nums.length-1;
        while(left+1<right){
            int mid = left + (right-left)/2;
            if(nums[mid]<nums[mid+1]){
                left=mid;
            }else{
                right=mid;
            }
        }
        return nums[left]>nums[right] ? left : right;
    }
}
