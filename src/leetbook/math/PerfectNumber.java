package leetbook.math;

import org.junit.Test;

/**
 * LC 507
 *
 * @author: Yihu4
 * @create: 2021-12-31 11:28
 */
public class PerfectNumber {
    @Test
    public void test() {
        System.out.println(checkPerfectNumberLC(28));
    }

    public boolean checkPerfectNumber(int num) {
        int eq = 0;
        for (int i = 1; i <= num/2; i++) {
            if (num % i == 0) {
                eq += i;
            }
        }
        if (eq == num) {
            return true;
        }
        return false;
    }
    public boolean checkPerfectNumberLC(int num) {
        int sum = 1;
        // i <= num / i 等价于 i * i <= num，可以防止溢出
        for (int i = 2; i <= num / i; i++) {
            if (num % i == 0) {
                sum += i;
                // 加上它对称的因子，排除完全平方数的情况
                // 加上它对称的因子，排除完全平方数的情况
                // 加上它对称的因子，排除完全平方数的情况
                if (i != num / i) {
                    sum += num / i;
                }
            }
        }
        // 注意 1 不是完美数，特殊处理一下
        return num != 1 && sum == num;
    }
}
