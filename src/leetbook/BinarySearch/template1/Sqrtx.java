package leetbook.BinarySearch.template1;

/**
 * LC 69
 * @author: Yihu4
 * @create: 2021-10-14 20:06
 */
public class Sqrtx {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1;
        int right = x;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            // 为了防止整数溢出, 故采用除法
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            } else if ((mid + 1) <= x / (mid + 1)) {
                left = mid + 1;
            } else if (mid > x / mid) {
                right = mid - 1;
            }
        }
        return -1;

    }
}
