package leetbook.SlidingWindow.init;

/**
 * LC 75
 *
 * @author: Yihu4
 * @create: 2021-11-06 15:06
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        for (int i = 0; i <= p2; i++) {
            while (i <= p2 && nums[i] == 2) {
                // 如果i=2,就把该值与p2所对的交换,然后p2向内前进
                // 如果换过来的还是2,重复该操作
                int tmp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = tmp;
                p2--;
            }
            if (nums[i] == 0) {
                // 如果i=0,就把该值与p1所对应的交换,然后p1向内前进
                int tmp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = tmp;
                p0++;
            }
        }
    }

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
}
