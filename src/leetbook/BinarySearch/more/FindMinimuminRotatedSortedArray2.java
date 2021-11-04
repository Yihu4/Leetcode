package leetbook.BinarySearch.more;

/**
 * LC 154
 * 存在重复
 * <p>
 * 旋转后的数组寻找最小
 *
 * @author: Yihu4
 * @create: 2021-10-26 21:30
 */
public class FindMinimuminRotatedSortedArray2 {
    public int findMin(int[] nums) {
        int left = 0;
        // -1 是为了防止判断是否左区间时越界
        int right = nums.length -1;
        while (left < right) {
            int mid = right + left >> 1;
            if (nums[mid] > nums[right]){
                left = mid + 1;
            }else if (nums[mid] < nums[right]){
                right = mid;
            }else {
                right = right - 1;
            }
        }
        return nums[left];
    }
}
