package leetbook.array_string.array;

/**
 * LC 35
 *
 * @author meteora
 */
public class SearchInsertPosition {
    public static void main(String[] args) {

    }

    public static int insert(int[] nums, int target) {
        // check
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 二分 复杂度符合O(logn)
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left =  mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
        /* 分解问题
           以上while循环中，若找到了target直接返回
           当原数组不包含target时，考虑while循环最后一次执行的总是 left=right=mid,

           此时nums[mid] 左边的数全部小于target，nums[mid]右边的数全部大于target,

           则此时我们要返回的插入位置分为两种情况：

           ①就是这个位置，即nums[mid] > target时，此时执行了right = mid - 1，left不变, 返回left正确

           ②是该位置的右边一个，即nums[mid] < target时，此时执行了left = mid + 1,返回left也正确
          */


        // 我的解 复杂度不符合
        /*if (nums[0] > target) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (target> nums[i - 1] && target < nums[i]) {
                return i -1;
            }

        }
        return -1;*/
    }
}
