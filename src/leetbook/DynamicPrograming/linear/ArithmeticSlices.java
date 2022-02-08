package leetbook.DynamicPrograming.linear;

/**
 * LC 413
 * 数组中等差数列个数
 * @author: Yihu4
 * @create: 2021-11-24 17:51
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
    int n = nums.length;
    if (n == 1) {
        return 0;
    }
    // 连续
    int d = nums[0] - nums[1], t = 0;
    int ans = 0;
    // 因为等差数列的长度至少为 3，所以可以从 i=2 开始枚举
    for (int i = 2; i < n; ++i) {
        if (nums[i - 1] - nums[i] == d) {
            // 每次等差数列长度增加,每次加的都+1(需要自己发现的规则)
            ++t;
        } else {
            // 如果差不相等,更新差
            d = nums[i - 1] - nums[i];
            // 更新序列数
            t = 0;
        }
        ans += t;
    }
    return ans;
    }
}
