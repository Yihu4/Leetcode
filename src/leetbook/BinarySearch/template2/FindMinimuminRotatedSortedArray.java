package leetbook.BinarySearch.template2;

/**
 * LC 153
 * 求正序数组旋转后的起点坐标
 *
 * @author: Yihu4
 * @create: 2021-10-21 20:16
 */
public class FindMinimuminRotatedSortedArray {
    // 旋转之后整个数组由两个递增的区间组成,最小值在第二个区间的最左边
    public int findMin(int[] nums) {
        int left = 0;
        // -1 是为了防止判断是否左区间时越界
        int right = nums.length -1;
        while (left < right) {
            int mid = right + left >> 1;
            // 通过与最右边的元素进行对比,判断中间点属于哪个区间
            // 命中右区间
            if (nums[mid] < nums[right]){
                // 如果中间点在右区间,则下次对左边进行判断,因为最小值在左边
                right = mid;
                // 命中左区间
            }else {
                // 如果中间点在左区间,则下次对右边进行判断,因为最小值在右边
                left = mid + 1;
            }
        }
        return nums[left];
    }

    // 双指针
    public static int FindMinDouble(int[] nums) {
        int slow = 0, fast = 1;
        // 直到快指针到头
        while (fast < nums.length) {
            // 如果在递增
            if (nums[slow] < nums[fast]) {
                fast++;
                // 找到悬崖了
            } else {
                return nums[fast];
            }
        }
        return nums[slow];
    }
}