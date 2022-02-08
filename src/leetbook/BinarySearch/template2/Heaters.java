package leetbook.BinarySearch.template2;

import org.junit.Test;

import java.util.Arrays;

/**
 * LC 475
 *
 * @author: Yihu4
 * @create: 2021-12-23 20:03
 */
public class Heaters {
    @Test
    public void test() {
        int[] ints = {1, 2, 3};
        int[] ints1 = {2};
        System.out.println(findRadius(ints, ints1));
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int l = 0;
        int r = (int) 1e9;
        while (l < r) {
            int mid = l + r >> 1;
            if (check(houses, heaters, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    boolean check(int[] houses, int[] heaters, int x) {
        int n = houses.length;
        int m = heaters.length;
        for (int i = 0, j = 0; i < n; i++) {
            // 如果当前位置大于加热器加上范围,则选用下一个加热器
            while (j < m && houses[i] > heaters[j] + x) {
                j++;
            }
            // 如果供暖期遍历得到,并且供暖期供暖范围符合,则跳过
            if (j < m && heaters[j] - x <= houses[i] && heaters[j] + x >= houses[i]) {
                continue;
            }
            // 否则返回false
            return false;
        }
        return true;
    }
}
