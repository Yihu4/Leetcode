package leetbook.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * LC 1005
 * 翻转(变负或者变正)一个数组的任意字符k次,可以重复翻转
 * 问最后总和是多少
 *
 * @author: Yihu4
 * @create: 2021-12-03 21:05
 */
public class MaximizeSumOfArrayAfterKNegations {
    @Test
    public void test() {
        int[] ints = {2, -3, -1, 5, -4};
        System.out.println(largestSumAfterKNegationsLC(ints, 2));
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        // 排序
        int count = k;
        while (count > 0) {
            Arrays.sort(nums);
            nums[0] = -nums[0];
            count--;
        }
        int res = 0;
        for (int i : nums) {
            res += i;
        }
        return res;
    }
    public int largestSumAfterKNegationsLC(int[] nums, int k) {
        int[] number = new int[201];//-100 <= A[i] <= 100,这个范围的大小是201
        for (int t : nums) {
            number[t + 100]++;//将[-100,100]映射到[0,200]上
        }
        int i = 0;
        while (k > 0) {
            while (number[i] == 0)//找到A[]中最小的数字
                i++;
            number[i]--;//此数字个数-1
            number[200 - i]++;//其相反数个数+1
            // 若原最小数索引>100,则新的最小数索引应为200-i.更新索引位置
            // 如果最小数索引<100,则不用更新,因为负数变为正数会继续找到
            if (i > 100) {
                i = 200 - i;
            }
            k--;
        }

        int sum = 0;
        // j=i是因为最后最小数索引只可能在i或者i之后
        for (int j = i; j <number.length ; j++) {//遍历number[]求和
            sum += (j-100)*number[j];//j-100是数字大小,number[j]是该数字出现次数.
        }
        return sum;
    }
}
