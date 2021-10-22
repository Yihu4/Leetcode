package leetbook.BinarySearch.template1;

/**
 * LC 33
 * @author: Yihu4
 * @create: 2021-10-20 19:23
 */
public class SearchinRotatedSortedArray {
    public static void main(String[] args) {
        int[] ints = new int[]{1,3};
        System.out.println(search(ints, 3));
    }
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 左递增
            if (nums[mid] > nums[right]){
                // 如果目标值在左递增区间, 并小于 mid 下标对应的值, 则缩小区间至 mid 左边
                // 注意等于号得有, 不然会错过
                if (nums[left] <= target && nums[mid] > target){
                    right = mid -1;
                }else /*if(target> nums[mid] || target<nums[left])*/{
                    left = mid + 1;
                }
            }else {
                if (target> nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else /*if (target < nums[mid] || target>nums[left])*/{
                    right = mid -1;
                }
            }
        }
        return -1;
    }
}
