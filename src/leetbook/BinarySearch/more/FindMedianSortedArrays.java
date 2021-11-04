package leetbook.BinarySearch.more;

/**
 * LC 4
 *
 * @author: Yihu4
 * @create: 2021-10-29 16:17
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        // 如果 (n + m) 为奇数, 则left = right
        int left = n + m + 1 >> 1;
        int right = n + m + 2 >> 1;
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        // 计算数组可处理部分长度
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        // 如果第一个数组比第二个长, 则交换数组, 保证如果数组被清空一定是第一个数组被清空
        if (len1 > len2) {
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        }
        // 如果一个数组被清空了, 那么直接返回第二个数组剩余的第k小的值
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }
        // 如果各自数组都还有元素, 并且k等于1, 那么直接比较两个数组的起始坐标对应的值
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        // 获取两个数组最终对比元素的下标, 如果越界(k/2超过数组长度), 那么下标为数组尾
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;
        if (nums1[i] > nums2[j]) {
            // 如果第一个数组的目标元素大于第二个数组的, 则增加len2的起点(等于排除起点之前的元素), 并且更新k=k-这次去除元素的数量
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }else {
            // 增加len1的起点
            return getKth(nums1,i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }


    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        // 如果两个数组长度相加是偶数,则结果会是中间的两个值相加除以2
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int getKth1(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        // 计算各自数组当前长度
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        // 让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        // 如果某一个数组为空就可以直接在另一个数组上面通过下标获取第k小的元素
        if (len1 == 0) return nums2[start2 + k - 1];
        // 如果还剩两个数组并且k等于1(只要找一个最小值), 就返回各自开始下标中的值
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        // 获取对比元素下标, 如果剩余长度小于k / 2, 则下标为数组中最后一个元素的下标
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            // 如果len1的比较元素大于len2的, 则将len2的起点增加(等于删除起点之前的元素), 并且k更新为k减去这次去掉元素的值
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }
}
