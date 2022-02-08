package leetbook.array;

import org.junit.Test;

/**
 * LC 1995
 *
 * @author: Yihu4
 * @create: 2021-12-29 19:11
 * a+b+c =d
 * 满足条件的数目
 */
// https://leetcode-cn.com/problems/count-special-quadruplets/solution/gong-shui-san-xie-yi-ti-si-jie-mei-ju-ha-gmhv/
public class CountSpecialQuadruplets {
    @Test
    public void test() {
        int[] ints = {1, 1, 1, 3, 5};
        System.out.println(countQuadrupletsN3(ints));
    }

    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        // 定义 f[i][j][k] 为考虑前 i 个物品（下标从 1 开始），凑成数值恰好 j，使用个数恰好为 k 的方案数。
        int[][][] f = new int[n + 1][110][4];
        f[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int t = nums[i - 1];
            for (int j = 0; j < 110; j++) {
                for (int k = 0; k < 4; k++) {
                    // 继承之前的次数
                    f[i][j][k] += f[i - 1][j][k];
                    if (j - t >= 0 && k - 1 >= 0) {
                        f[i][j][k] += f[i - 1][j - t][k - 1];
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 3; i < n; i++) {
            ans += f[i][nums[i]][3];
        }
        return ans;
    }

    // DP优化
    public int countQuadrupletsOp(int[] nums) {
        int n = nums.length, ans = 0;
        int[][] f = new int[110][4];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int t = nums[i - 1];
            ans += f[t][3];
            for (int j = 109; j >= 0; j--) {
                for (int k = 3; k >= 0; k--) {
                    if (j - t >= 0 && k - 1 >= 0) f[j][k] += f[j - t][k - 1];
                }
            }
        }
        return ans;
    }

    // 暴力
    public int countQuadrupletsN4(int[] nums) {
        int n = nums.length, ans = 0;
        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                for (int c = b + 1; c < n; c++) {
                    for (int d = c + 1; d < n; d++) {
                        if (nums[a] + nums[b] + nums[c] == nums[d]) {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public int countQuadrupletsN3(int[] nums) {
        int n = nums.length, ans = 0;
        int[] cnt = new int[20];
        for (int c = n - 2; c >= 2; c--) {
            cnt[nums[c + 1]]++;
            for (int a = 0; a < n; a++) {
                for (int b = a + 1; b < c; b++) {
                    // 当cnt的下标为nums[a] + nums[b] + nums[c]在cnt中有数时,满足条件
                    ans += cnt[nums[a] + nums[b] + nums[c]];
                }
            }
        }
        return ans;
    }

    // N2
    // 一些细节：由于 nums[d] - nums[c] 可能为负，在使用数组代替哈希表时，可利用 1 <= nums[i] <= 100 做一个值偏移。
    public int countQuadrupletsN2(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int[] cnt = new int[10010];
        for (int b = n - 3; b >= 1; b--) {
            for (int d = b + 2; d < n; d++) {
                cnt[nums[d] - nums[b + 1] + 200]++;
            }
            for (int a = 0; a < b; a++) {
                ans += cnt[nums[a] + nums[b] + 200];
            }
        }
        return ans;
    }
}
