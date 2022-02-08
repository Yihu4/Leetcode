package leetbook.DynamicPrograming.unclassified;


import org.junit.Test;

/**
 * LC 1137
 * @author: Yihu4
 * @create: 2021-11-15 20:31
 */
public class NthTribonacciNumber {
    @Test
    public void test(){
        System.out.println(tribonacciFast(4));
    }
    public int tribonacci(int n) {
        if (n==0){
            return 0;
        }
        if (n==1||n==2){
            return 1;
        }
        int prePrePre=0;
        int prePre = 1;
        int pre = 1;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = prePrePre+prePre+pre;
            prePrePre = prePre;
            prePre = pre;
            pre = res;
        }
        return res;
    }

    // 记忆化
    int[] cache = new int[40];
    public int tribonacciMemo(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        if (cache[n] != 0) return cache[n];
        cache[n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        return cache[n];
    }

    int N = 3;
    int[][] mul(int[][] a, int[][] b) {
        int[][] c = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j] + a[i][2] * b[2][j];
            }
        }
        return c;
    }
    public int tribonacciFast(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[][] ans = new int[][]{
                {1,0,0},
                {0,1,0},
                {0,0,1}
        };
        int[][] mat = new int[][]{
                {1,1,1},
                {1,0,0},
                {0,1,0}
        };
        int k = n - 2;
        while (k != 0) {
            if ((k & 1) != 0) {
                ans = mul(ans, mat);
            }
            mat = mul(mat, mat);
            k >>= 1;
        }
        return ans[0][0] + ans[0][1];
    }
}
