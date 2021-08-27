package leetbook.array_string.arrayrelati;

/**
 * LC 153
 * 二分找最小
 * @author: mete0ra
 * @create: 2021-08-27 09:30
 */
public class FindMinimumRotatedSortedArray {
    public static void main(String[] args) {
        // 0 6
        int[] ints = {4, 5, 6, 1, 2, 3, 4};
        System.out.println(findMin1(ints));

    }
    // 两个正序
    public static int findMin1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        // 二分整个数组
        while (left < right) {
            int mid = (left + right) / 2;
            // 确定新范围
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    // 双指针
    public static int FindMinDouble(int[] nums) {
        int slow=0, fast=1;
        while(fast<nums.length){
            if(nums[slow]<nums[fast]){
                fast++;
            } else {
                return nums[fast];
            }
        }
        return nums[slow];
    }

}
