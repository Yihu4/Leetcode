package leetbook.DynamicPrograming.linear;

import org.junit.Test;

import java.util.Arrays;

/**
 * LC 1388
 * 选一个则左右两边各消失一个元素
 * 是一个circle,可以跨边界
 * @author: Yihu4
 * @create: 2021-12-02 10:48
 */
public class PizzaWith3nSlices {
    // https://leetcode-cn.com/problems/pizza-with-3n-slices/solution/shuang-xiang-lian-biao-tan-xin-suan-fa-shi-jian-fu/
    // 反悔
    @Test
    public void test(){
        int[] ints = {4, 1, 2, 5, 8, 3, 1, 9, 7};
        System.out.println(maxSizeSlices(ints));
    }
    public int maxSizeSlices(int[] slices) {
        // slices1为slices去头
        int[] slices1 = new int[slices.length - 1];
        System.arraycopy(slices, 1, slices1, 0, slices.length - 1);
        System.out.println(Arrays.toString(slices1));
        // slices2为slices去尾
        int[] slices2 = new int[slices.length - 1];
        System.arraycopy(slices, 0, slices2, 0, slices.length - 1);
        System.out.println(Arrays.toString(slices2));
        // 因为是环,去头去尾分别比一次
        int ans1 = calculate(slices1);
        int ans2 = calculate(slices2);
        return Math.max(ans1, ans2);
    }

    public int calculate(int[] slices) {
        int n = slices.length;
        int choose = (n + 1) / 3;
        // dp[i][j] 数组前i个里面,选j个不相邻的数的最大和
        int[][] dp = new int[n + 1][choose + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= choose; ++j) {
                // 比较前一个位置(这次不取) 和 前前个位置(这次取)+这次的大小
                dp[i][j] = Math.max(dp[i - 1][j],
                        (i - 2 >= 0 ? dp[i - 2][j - 1] : 0) + slices[i - 1]);
            }
        }
        return dp[n][choose];
    }


}
