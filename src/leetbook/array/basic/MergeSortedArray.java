package leetbook.array.basic;

import org.junit.Test;

import java.util.Arrays;

/**
 * LC 88
 * 合并两个有序数组(非递减
 *
 * @author: Yihu4
 * @create: 2021-11-05 21:03
 */
public class MergeSortedArray {
    @Test
    public void test() {
        int[] ints = {1, 2, 3, 0, 0, 0};
        int[] ints1 = {2, 5, 6};
        mergeAg(ints, 3, ints1, 3);
        System.out.println(Arrays.toString(ints));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                // 如果某一个数组赋值完了
                // 那么cur直接就等于另一个数组顺延
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                // 比较各自数组尾
                // 大的一边赋值,并且指针向前移
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            // 从尾开始赋值
            nums1[tail--] = cur;
        }
    }

    // again
    public void mergeAg(int[] nums1, int m, int[] nums2, int n) {
        int tail = m + n - 1;
        while (m > 0 || n > 0) {
            if (m==0){
                nums1[tail]=nums2[n-1];
                n--;
            }else if (n==0){
                nums1[tail]=nums1[m-1];
                m--;
            }else if (nums1[m - 1] >= nums2[n - 1]) {
                nums1[tail] = nums1[m - 1];
                m--;
            } else {
                nums1[tail] = nums2[n - 1];
                n--;
            }
            tail--;
        }
    }

    // 死胡同
    /*public void merge(int[] nums1, int m, int[] nums2, int n) {
        boolean flag = false;
        int right = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] > nums2[right]) {
                if (nums1[i]==0){
                    flag = true;
                }
                int tmp = nums1[i];
                nums1[i] = nums2[right];
                nums2[right] = tmp;
                if (flag)right++;
            } else if (nums1[i]==nums2[right]){
                nums1[i] = nums2[right];
            }
            if (right < nums2.length - 1 && nums2[right] > nums2[right + 1]) {
                int temp = nums2[right];
                nums2[right] = nums2[right + 1];
                nums2[right + 1] = temp;
            }
        }
    }*/
}
