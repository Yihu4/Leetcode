package leetbook.BinarySearch;

/**
 * LC 704
 *
 * @author: Yihu4
 * @create: 2021-10-14 19:23
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] ints = {2, 4, 5, 6, 7};
        System.out.println(search5(ints, 7));
    }
    // 复杂度log n
    // 复杂度log n
    // 复杂度log n

    // left + right + 1 >> 1
    // left = mid;
    // right = mid - 1;
    public static int search4(int[] nums, int target) {
        int left = 0;
        // 通过拉长数组
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    // left + right >>1
    // right = mid;
    // left = mid + 1;
    public static int search5(int[] nums, int target) {
        int left = 0;
        // 通过拉长数组
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 二分查找的最基础和最基本的形式。
     * 查找条件可以在不与元素的两侧进行比较的情况下确定（或使用它周围的特定元素）。
     * 不需要后处理，因为每一步中，你都在检查是否找到了元素。如果到达末尾，则知道未找到该元素。
     */
    public int search1(int[] nums, int target) {
        int left = 0;
        // -1
        int right = nums.length - 1;
        // =
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                // -1
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 一种实现二分查找的高级方法。
     * 查找条件需要访问元素的直接右邻居。
     * 使用元素的右邻居来确定是否满足条件，并决定是向左还是向右。
     * 保证查找空间在每一步中至少有 2 个元素。
     * 保证查找空间在每一步中至少有 2 个元素。
     * 保证查找空间在每一步中至少有 2 个元素。
     * 需要进行后处理。 当你剩下 1 个元素时，循环 / 递归结束。 需要评估剩余元素是否符合条件。
     */
    // 如果查找空间在最后一步中只有一个元素,则通不过 left<right 的判断
    public static int search2(int[] nums, int target) {
        int left = 0;
        // 通过拉长数组
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }

    /**
     * 实现二分查找的另一种方法。
     * 搜索条件需要访问元素的直接左右邻居。
     * 使用元素的邻居来确定它是向右还是向左。
     * 保证查找空间在每个步骤中至少有 3 个元素。
     * 需要进行后处理。当剩下 2 个元素时，循环 / 递归结束。需要评估其余元素是否符合条件。
     */
    public int search3(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return -1;
    }
}
