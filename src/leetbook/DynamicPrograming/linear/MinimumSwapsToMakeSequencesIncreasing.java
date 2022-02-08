package leetbook.DynamicPrograming.linear;

import org.junit.Test;

import java.util.Arrays;

/**
 * LC 801
 * 交换两个相同长度数组 相同下标的数字
 * 返回可以使两个数组都变成严格递增数组的最小次数
 *
 * @author: Yihu4
 * @create: 2021-12-10 17:12
 */
public class MinimumSwapsToMakeSequencesIncreasing {
    @Test
    public void test() {
        int[] ints = {0, 2, 7, 8};
        int[] ints1 = {1, 5, 4, 9};
        System.out.println(minSwap(ints, ints1));
    }

    // https://leetcode-cn.com/problems/minimum-swaps-to-make-sequences-increasing/solution/leetcode-801-wo-gan-jio-ying-gai-jiang-de-hen-tou-/
    public int minSwap(int[] nums1, int[] nums2) {
        int[] keep = new int[nums1.length];
        int[] swap = new int[nums1.length];
        // 当前不交换用的次数
        keep[0] = 0;
        // 当前交换用的次数,默认交换一次
        swap[0] = 1;
        for (int i = 1; i < nums1.length; i++) {
            // 同时满足交叉和平行
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1] && nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                // 不交换
                keep[i] = Math.min(keep[i - 1], swap[i - 1]);
                // 交换
                swap[i] = Math.min(keep[i - 1], swap[i - 1]) + 1;
                continue;
            }
            // 不满足交叉,只满足平行
            // 则前后必须同时交换或者不交换
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                // 不交换, 则继承之前不交换的次数
                keep[i] = keep[i - 1];
                // 交换, 则继承之前交换的次数并加上一次交换
                swap[i] = swap[i - 1] + 1;
            }
            // 只满足交叉
            // 则前后必须不相同,如果i交换 i-1 必须不交换 反之亦然
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                // 不交换, 则继承之前一次交换的次数
                keep[i] = swap[i - 1];
                // 交换, 则继承之前一次不交换的次数 并加上一次交换
                swap[i] = keep[i - 1] + 1;
            }
        }
        return Math.min(keep[nums1.length-1],swap[nums2.length-1]);
    }
}
