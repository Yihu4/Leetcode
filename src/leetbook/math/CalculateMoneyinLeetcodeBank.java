package leetbook.math;

import org.junit.Test;

/**
 * LC 1716
 *
 * @author: Yihu4
 * @create: 2022-01-15 09:35
 */
public class CalculateMoneyinLeetcodeBank {
    @Test
    public void test() {
        System.out.println(totalMoney(10));
        System.out.println(1/Math.exp(7.0));
    }

    public int totalMoney(int n) {
        int num = n / 7;
        int index = n % 7;
        int res = 0;
        int base = (1 + 7) * 7 / 2;
        res += num * base;
        if (num >= 1) {
            res += (0 + (num - 1) * 7) * num / 2;
        }
        for (int i = 1; i <= index; i++) {
            res += i + num;
        }
        return res;
    }
}
