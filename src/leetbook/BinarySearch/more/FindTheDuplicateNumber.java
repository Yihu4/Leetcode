package leetbook.BinarySearch.more;

/**
 * LC 287
 *
 * @author: Yihu4
 * @create: 2021-10-28 17:40
 */
public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        int i = 7 ^ 2;
        System.out.println(i);
    }

    public int findDuplicateSlowFast(int[] nums) {
        int slow = 0;
        int fast = 0;
        // 快指针的速度是慢指针的两倍
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // 相遇之后快指针走的路是慢指针的两倍, 而这领先的一部分全部是在环里面
        // 定义一个finder从头开始走, slow也继续走, 当他们相遇时就是入口所在
        int finder = 0;
        while (finder != slow) {
            finder = nums[finder];
            slow = nums[slow];
        }
        return finder;
    }


    // 二分
    public int findDuplicateBinarySearch(int[] nums) {
        int left = 1, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
        // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个，此时重复元素一定出现在 [1..4] 区间里
            if (count > mid) {
        // 重复元素位于区间 [left..mid]
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
}
