package leetbook.queue_stack.stack_dfs;

/**
 * https://leetcode-cn.com/problems/target-sum/solution/mu-biao-he-by-leetcode-solution-o0cp/
 */

public class FindTargetSumWaysXXX {
    static int count = 0;
    //dfs1
    static int ans = 0;

    public static void main(String[] args) {
        int[] a = {1,1,1,1};
        System.out.println(findTargetSumWaysBT(a,2));
        // 使用全局变量维护
        // dfs1(a, 2, 0, 0);
        // System.out.println(ans);

        System.out.println();dp(a,2);
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

    // https://leetcode-cn.com/problems/target-sum/solution/gong-shui-san-xie-yi-ti-si-jie-dfs-ji-yi-et5b/
    // DFS使用全局变量
    public static void dfs1(int[] nums, int target, int u, int cur) {
        if (u == nums.length) {
            ans += cur == target ? 1 : 0;
            return;
        }
        dfs1(nums, target, u + 1, cur + nums[u]);
        dfs1(nums, target, u + 1, cur - nums[u]);
    }

    // DFS接收返回值
    public static int dfs2(int[] nums, int target, int u, int cur) {
        if (u == nums.length) {
            return cur == target ? 1 : 0;
        }
        int left = dfs2(nums, target, u + 1, cur + nums[u]);
        int right = dfs2(nums, target, u + 1, cur - nums[u]);
        return left + right;

    }

    // DP动态规划
    public static int dp(int[] nums, int target) {
        int n = nums.length;
        int s = 0;
        for (int i : nums) {
            s += Math.abs(i);
        }
        // 如果大于绝对值相加, 直接无效
        if (target > s) {
            return 0;
        }
        int[][] f = new int[n + 1][2 * s + 1];
        // s的右偏移
        f[0][s] = 1;
        for (int i = 1; i <= n; i++) {
            int x = nums[i - 1];
            for (int j = -s; j <= s; j++) {
                if ((j - x) + s >= 0) {
                    f[i][j + s] += f[i - 1][(j - x) + s];
                }
                if ((j + x) + s <= 2 * s) {
                    f[i][j + s] += f[i - 1][(j + x) + s];
                }
            }
        }
        return f[n][target + s];
    }


}
