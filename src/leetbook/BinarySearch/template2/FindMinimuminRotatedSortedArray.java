package leetbook.BinarySearch.template2;

/**
 * LC 153
 * 求正序数组旋转后的起点坐标
 *
 * @author: Yihu4
 * @create: 2021-10-21 20:16
 */
public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0;
        // -1 是为了防止判断是否左区间时越界
        int right = nums.length -1;
        while (left < right) {
            int mid = right + left >> 1;
            // 命中左区间
            if (nums[mid] > nums[right]){
                left = mid + 1;
                // 命中右区间
            }else {
                right = mid;
            }
        }
        return nums[left];
    }
}
