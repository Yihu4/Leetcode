package leetbook.queue_stack.stack_dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 494
 * https://leetcode-cn.com/problems/target-sum/solution/mu-biao-he-by-leetcode-solution-o0cp/
 */

public class FindTargetSumWaysXXX {
    static int count = 0;
    //dfs1
    static int ans = 0;

    public static void main(String[] args) {
        int[] a = {2, 1};
        // 使用全局变量维护

        // dfs1(a, 2, 0, 0);
        // System.out.println(ans);

        System.out.println(dp(a, 2));
    }

    public static int findTargetSumWaysBT(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return count;
    }

    // 回溯
    public static void backtrack(int[] nums, int target, int index, int sum) {
        // index == nums.length 判断是否对数组内的所有数字进行运算
        if (index == nums.length) {
            // 总和和目标相等,则count++
            if (sum == target) {
                count++;
            }
        } else {
            // 遍历所有表达式!!!
            backtrack(nums, target, index + 1, sum + nums[index]);
            backtrack(nums, target, index + 1, sum - nums[index]);
        }
    }

    /**
     * https://leetcode-cn.com/problems/target-sum/solution/gong-shui-san-xie-yi-ti-si-jie-dfs-ji-yi-et5b/
     * DFS使用全局变量
     */
    public static void dfs1(int[] nums, int target, int u, int cur) {
        if (u == nums.length) {
            // 每找到一条ans + 1
            ans += cur == target ? 1 : 0;
            return;
        }
        // 加号
        dfs1(nums, target, u + 1, cur + nums[u]);
        // 减号
        dfs1(nums, target, u + 1, cur - nums[u]);
    }

    // DFS接收返回值
    public static int dfs2(int[] nums, int target, int u, int cur) {
        // 当u为数组长度(即用完所有数字)时
        if (u == nums.length) {
            // 判断当前值与目标值
            return cur == target ? 1 : 0;
        }
        // 加号
        int left = dfs2(nums, target, u + 1, cur + nums[u]);
        // 减号
        int right = dfs2(nums, target, u + 1, cur - nums[u]);
        return left + right;

    }

    // 记忆化
    public static int findTargetSumWaysmemo(int[] nums, int t) {
        return dfs(nums, t, 0, 0);
    }

    static Map<String, Integer> cache = new HashMap<>();

    static int dfs(int[] nums, int t, int u, int cur) {
        // 两个维度, 当前的key
        // 从后往前存储
        String key = u + "_" + cur;
        if (cache.containsKey(key)) {
            // 通过key 得到已经记忆化过的value
            return cache.get(key);
        }
        if (u == nums.length) {
            // 找到一条路置为0
            cache.put(key, cur == t ? 1 : 0);
            return cache.get(key);
        }
        int left = dfs(nums, t, u + 1, cur + nums[u]);
        int right = dfs(nums, t, u + 1, cur - nums[u]);
        cache.put(key, left + right);
        return cache.get(key);
    }

    // DP动态规划
    public static int dp(int[] nums, int target) {
        int n = nums.length;
        // 绝对值相加
        int s = 0;
        for (int i : nums) {
            s += Math.abs(i);
        }
        // 如果大于绝对值相加, 直接无效
        if (target > s) {
            return 0;
        }
        // 转移方程:f[i][j]=f[i−1][j−nums[i−1]]+f[i−1][j+nums[i−1]]
        // 当前目标的数量, 是当前数字去掉当前目标的加减数量相加
        // f[i][j] 代表考虑前 i 个数，当前计算结果为 j 的方案数，令 nums 下标从 1 开始。
        int[][] f = new int[n + 1][2 * s + 1];
        // s的右偏移, s左边为负,右边为正
        // 不考虑任何数，凑出计算结果为 0 的方案数为 1 种。因为当一个数的时候根据转移方程可以逆推.
        f[0][s] = 1;
        // i = 1 是为了考虑f[0][s]的初始值
        for (int i = 1; i <= n; i++) {
            // 等于是 i = 0; i < n
            int x = nums[i - 1];
            for (int j = -s; j <= s; j++) {
                // target范围在[0,2s]之间
                if ((j - x) + s >= 0) {
                    f[i][j + s] += f[i - 1][(j - x) + s];
                }
                if ((j + x) + s <= 2 * s) {
                    f[i][j + s] += f[i - 1][(j + x) + s];
                }
            }
        }
        // 返回达成目标的次数
        return f[n][target + s];
    }

    // DP动态规划优化
    public int dpOptimize(int[] nums, int t) {
        int n = nums.length;
        int s = 0;
        for (int i : nums) {
            s += Math.abs(i);
        }
        if (t > s || (s - t) % 2 != 0) {
            return 0;
        }
        int m = (s - t) / 2;
        int[][] f = new int[n + 1][m + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int x = nums[i - 1];
            for (int j = 0; j <= m; j++) {
                f[i][j] += f[i - 1][j];
                if (j >= x) {
                    f[i][j] += f[i - 1][j - x];
                }
            }
        }
        return f[n][m];
    }

}
