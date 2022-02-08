package leetbook.math;

/**
 * LC 372
 * @author: Yihu4
 * @create: 2021-12-06 09:04
 */
public class SuperPow {
    int MOD = 1337;
    public int superPow(int a, int[] b) {
        return dfs(a, b, b.length - 1);
    }
    int dfs(int a, int[] b, int u) {
        if (u == -1) return 1;
        return pow(dfs(a, b, u - 1), 10) * pow(a, b[u]) % MOD;
    }
    int pow(int a, int b) {
        int ans = 1;
        a %= MOD;
        while (b-- > 0) ans = ans * a % MOD;
        return ans;
    }
}
