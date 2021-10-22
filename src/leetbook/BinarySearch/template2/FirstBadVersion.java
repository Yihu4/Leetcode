package leetbook.BinarySearch.template2;

/**
 * LC 278
 *
 * @author: Yihu4
 * @create: 2021-10-20 21:03
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;

        while (left < right) {

            int mid = left + (right - left) / 2;
            // 找左边
            /*if (is(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
             */
        }
        return left;
    }
}
