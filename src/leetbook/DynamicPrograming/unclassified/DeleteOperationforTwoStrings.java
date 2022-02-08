package leetbook.DynamicPrograming.unclassified;


import org.junit.Test;

/**
 * LC 583
 *
 * @author: Yihu4
 * @create: 2021-12-09 20:32
 */
public class DeleteOperationforTwoStrings {
    @Test
    public void test(){
        System.out.println(minDistance("sea", "eat"));
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        // LC 1143
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 如果相等,共同子序列+1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 如果不相等, 从左或者上转移
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // 两个长度减去共同子序列的两倍就是两个字符串不同的总和,也就是需要删除的次数
        return m + n - 2 * dp[m][n];
    }
}
