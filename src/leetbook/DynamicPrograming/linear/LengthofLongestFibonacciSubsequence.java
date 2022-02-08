package leetbook.DynamicPrograming.linear;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 873
 * 给一个严格递增的数组,求出里面最长斐波那契数列的长度
 *
 * @author: Yihu4
 * @create: 2021-12-02 16:13
 */
public class LengthofLongestFibonacciSubsequence {
    @Test
    public void test() {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(lenLongestFibSubseqLC(ints));
    }

    public int lenLongestFibSubseq(int[] arr) {
        // dp[i][j]表示以 arr[i] arr[j]结尾的斐波那契长度
        int[][] dp = new int[arr.length - 1][arr.length];
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }


        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int stepLen = arr[j] - arr[i];//arr[k]
                if (map.containsKey(stepLen) && map.get(stepLen) < i) {
                    int k = map.get(stepLen);
                    // 之前的长度+1
                    dp[i][j] = dp[k][i] + 1;
                    // 当前的长度+2
                    maxLen = Math.max(maxLen, dp[i][j] + 2);
                }
            }
        }
        return maxLen;
    }

    // 转换为LC 300
    public int lenLongestFibSubseqLC(int[] A) {
        int N = A.length;
        Map<Integer, Integer> index = new HashMap();
        for (int i = 0; i < N; ++i)
            index.put(A[i], i);

        Map<Integer, Integer> longest = new HashMap();
        int ans = 0;

        for (int k = 0; k < N; ++k)
            for (int j = 0; j < k; ++j) {
                int i = index.getOrDefault(A[k] - A[j], -1);
                if (i >= 0 && i < j) {
                    // 寻找之前以arr[i] arr[j]结尾的最长斐波那契路径
                    int cand = longest.getOrDefault(i * N + j, 2) + 1;
                    // 记录当前以arr[j] arr[k]结尾的最长斐波那契路径
                    longest.put(j * N + k, cand);
                    ans = Math.max(ans, cand);
                }
            }
        return ans >= 3 ? ans : 0;
    }
}
