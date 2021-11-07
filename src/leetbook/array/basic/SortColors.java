package leetbook.array.basic;

/**
 * LC 75
 *
 * @author: Yihu4
 * @create: 2021-11-04 19:53
 */
public class SortColors {

    public void sortColorsQuickSort(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        quick_sort(nums, l, r);
    }

    private void quick_sort(int[] nums, int l, int r) {
        if (l >= r) return;
        int i = l - 1;
        int j = r + 1;
        int x = nums[l + r >> 1];
        while (i < j) {
            do {
                i++;
            } while (nums[i] < x);
            do {
                j--;
            } while (nums[j] > x);
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        quick_sort(nums, l, j);
        quick_sort(nums, j + 1, r);
    }

    // 双指针(从头)
    public void sortColorsDoublePointer(int[] nums) {
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int tmp = nums[i];
                nums[i] = nums[p1];
                nums[p1++] = tmp;
            } else if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = tmp;
                if (p0 < p1) {
                    // 如果已经有1在0后面了
                    // 交换当前的p1和num[i]
                    tmp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = tmp;
                }
                // 再把两个指针都+1
                p0++;
                p1++;
            }
        }
    }
    // 双指针(两边)
    public void sortColorsDoublePointerCompress(int[] nums) {
        int p0 = 0;
        int p2 = nums.length -1;
        for (int i = 0; i <= p2; i++) {
            while (i <= p2 && nums[i] == 2){
                int tmp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = tmp;
                p2--;
            }
            if (nums[i] == 0){
                int tmp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = tmp;
                p0++;
            }
        }
    }

    // 双指针(两边)
    // 一次循环
    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }

        // all in [0, zero) = 0
        // all in [zero, i) = 1
        // all in [two, len - 1] = 2

        // 循环终止条件是 i == two，那么循环可以继续的条件是 i < two
        // 为了保证初始化的时候 [0, zero) 为空，设置 zero = 0，
        // 所以下面遍历到 0 的时候，先交换，再加
        int zero = 0;

        // 为了保证初始化的时候 [two, len - 1] 为空，设置 two = len
        // 所以下面遍历到 2 的时候，先减，再交换
        int two = len;
        int i = 0;
        // 当 i == two 上面的三个子区间正好覆盖了全部数组
        // 因此，循环可以继续的条件是 i < two
        while (i < two) {
            if (nums[i] == 0) {
                swap(nums, i, zero);
                zero++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                two--;
                swap(nums, i, two);
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
