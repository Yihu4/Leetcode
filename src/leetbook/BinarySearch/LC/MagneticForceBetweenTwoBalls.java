package leetbook.BinarySearch.LC;

import org.junit.Test;

import java.util.Arrays;

/**
 * LC 1552
 * @author: Yihu4
 * @create: 2021-11-03 19:20
 */
public class MagneticForceBetweenTwoBalls {
    @Test
    public void test() {
        int[] ints = {1, 2, 3, 4, 7};
        System.out.println(maxDistance(ints, 3));
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        // 最大间隔
        int max = position[position.length - 1] - position[0];
        // 最小间隔
        int left = Integer.MAX_VALUE;
        for (int i = 1; i < position.length; i++) {
            left = Math.min(left, position[i] - position[i - 1]);
        }
        if (m == 2) {
            return max;
        }
        int right = max / (m - 1);
        int ans = 1;
        while (left <= right) {
            int mid = left + right >> 1;
            // int check = check(mid, position, m);
            if (check(mid, position, m) >= m) {
                // 如果相等还要继续缩,因为具体情况可能不相符
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 或者return left - 1
        return ans;
    }

    private int check(int distance, int[] position, int m) {
        int count = 1;
        int target = position[0] + distance;
        for (int i : position) {
            if (i >= target) {
                target = i + distance;
                count++;

            }
        }
        return count;
    }
}
