package leetbook.BinarySearch.template2;

/**
 * LC 162
 * 找任何一个峰
 * 左右元素不相等
 *
 * @author: Yihu4
 * @create: 2021-10-21 18:15
 */
public class FindPeakElement {
    public static void main(String[] args) {
        int i = 8;
        int a = i + 2 >> 1;
        System.out.println(a);
    }

    // 线性找峰
    public int findPeakElementLinear(int[] nums) {
        // 长度
        int length = nums.length;
        // 对每个进行前后的比对
        for (int i = 0; i < length; i++) {
            // 标记
            boolean ok = true;
            // 比左边, 去头
            if (i - 1 >= 0) {
                if (nums[i - 1] > nums[i]) {
                    ok = false;
                }
            }
            // 比右边, 去尾
            if (i + 1 < length) {
                if (nums[i + 1] > nums[i]) {
                    ok = false;
                }
            }
            if (ok) {
                return i;
            }
        }
        return -1;
    }

    public int findPeakElement1(int[] nums) {
        int n = nums.length;
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1]) {
                // mid 要在新区间之中
                r = mid;
            } else {
                // mid 不在新区间之中
                l = mid + 1;
            }
        }
        return r;
    }

    public int findPeakElement2(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] > nums[mid - 1]) l = mid;
            else r = mid - 1;
        }
        return r;
    }


}
