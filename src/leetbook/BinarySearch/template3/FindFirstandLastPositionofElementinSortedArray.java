package leetbook.BinarySearch.template3;

import org.junit.Test;

import java.util.Arrays;

/**
 * LC 34
 * Given an array of integers nums sorted in non-decreasing order,
 *
 * find the starting and ending position of a given target value.
 * <p>
 * If target is not found in the array, return [-1, -1].
 * <p>
 * You must write an algorithm withO(log n) runtime complexity.
 *
 * @author: Yihu4
 * @create: 2021-10-25 19:44
 */
public class FindFirstandLastPositionofElementinSortedArray {
    @Test
    public void test() {
        int[] ints = {1, 1, 2, 2, 2, 2, 5};
        System.out.println(Arrays.toString(searchRange(ints, 79)));
    }

    //先找>=target的第一个
    //再找>target的第一个
    public int[] searchRange(int[] nums, int target) {
        int l = search(nums, target);
        int r = search(nums, target + 1);
        // 如果数字超过了数组里面的最大值,则 l == nums.length
        // 如果越界,或者起点对不上
        if (l == nums.length || nums[l] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{l, r - 1};
    }

    //找>=target的第一个
    public int search(int[] nums, int target) {
        // -1则找左
        int l = 0, r = nums.length;
        while (l < r) {
            // 向下取整
            int mid = (r + l) >> 1;
            if (nums[mid] >= target)
                r = mid;
            else
                //向下取整后加一
                l = mid + 1;
        }
        // 因为最后只有一个元素,所以返回左或者右没有区别
        return r;
    }
}