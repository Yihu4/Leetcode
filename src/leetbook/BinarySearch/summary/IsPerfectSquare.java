package leetbook.BinarySearch.summary;

/**
 * LC 367
 *
 * @author: Yihu4
 * @create: 2021-10-26 20:54
 */
public class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {
        // 向上取整
        int left = 1;
        int right = num;
        while (left <= right) {
            // 防止溢出
            int mid = (right - left) / 2 + left;
            // 防止溢出
            if (num % mid == 0 && mid == num / mid) {
                return true;
            } else if (mid < num / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
