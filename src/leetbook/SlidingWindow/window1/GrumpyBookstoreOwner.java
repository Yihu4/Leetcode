package leetbook.SlidingWindow.window1;

import org.junit.Test;

/**
 * LC 1052
 * input:
 * customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * <p>
 * output:16
 *
 * @author: Yihu4
 * @create: 2021-11-06 16:27
 */
public class GrumpyBookstoreOwner {
    @Test
    public void test() {
        int[] customers = {3};
        int[] grumpyyy = {1};
        System.out.println(maxSatisfied(customers, grumpyyy, 1));
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum = 0;
        // 计算正常情况下的顾客数
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] != 1) {
                sum += customers[i];
            }
        }
        // 挽回顾客数
        int save = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                save += customers[i];
            }
        }
        int res = save;
        for (int i = minutes; i < customers.length; i++) {
            if (grumpy[i - minutes] == 1) {
                save -= customers[i - minutes];
            }
            if (grumpy[i] == 1) {
                save += customers[i];
            }
            res = Math.max(res, save);

        }
        return sum + res;
    }
}
