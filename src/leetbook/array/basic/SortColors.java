package leetbook.array.basic;

import org.junit.Test;

/**
 * LC 75
 *
 * @author: Yihu4
 * @create: 2021-11-04 19:53
 */
public class SortColors {

    @Test
    public void test(){
        int[] ints = {2,1,5};
        sortColorsQuickSort(ints);
        System.out.println("x");
    }
    public void sortColorsQuickSort(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        quick_sort(nums, l, r);
    }

    private void quick_sort(int[] nums, int l, int r) {
        if (l >= r) return;
        int i = l-1;
        int j = r+1 ;
        int x = nums[l + r >> 1];
        while (i < j) {
            do {
                // 先移动左指针,停止时,<x的数在左边
                i++;
            } while (nums[i] < x);
            do {
                // 再移动右指针,停止时,>x的数在右边
                j--;
            } while (nums[j] > x);
            // 两个指针都无路可走则交换, 各取所需
            // 因为是 do while 所以=x的值可能在左也可能在右
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        quick_sort(nums, l, j);
        quick_sort(nums, j + 1, r);
    }

    // 可能会有数据倾斜
    public void quickSort(int a[],int left,int right ){

        if(left>=right) return;

        int pivot=a[left];
        int i=left;
        int j=right;

        //如果左右指针碰头就代表这一轮迭代结束
        while (i!=j){
            //先从右边开始,找小于pivot点的数字
            //因此，循环的条件是如果大于pivot就继续查找
            //小于pivot就停止
            while(a[j]>=pivot&&i<j){
                j--;
            }
            //后从左边开始，找大于pivot的数字
            //因此，循环的条件是如果是小于pivot就继续查找
            //大于pivot就停止
            while(a[i]<=pivot&&i<j){
                i++;
            }

            if(i<j) {
                //交换两个数字
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }

        }

        //基准归位
        a[left]=a[i];
        a[i]=pivot;

        quickSort(a,left,i-1);

        quickSort(a,i+1,right);

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
