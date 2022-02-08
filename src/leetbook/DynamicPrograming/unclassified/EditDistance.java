package leetbook.DynamicPrograming.unclassified;

import org.junit.Test;

/**
 * LC 73
 * convert word1 to word2
 * can use
 * insert/delete/replace
 *
 * @author: Yihu4
 * @create: 2021-12-04 15:15
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 */
public class EditDistance {
    @Test
    public void test() {
        System.out.println(minDistance("horse", "ros"));
    }

    // 不行,因为有位置顺序关系
    public int minDistanceOut(String word1, String word2) {
        int[] letter1 = new int[26];
        int[] letter2 = new int[26];
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        for (char c : w1) {
            letter1[c - 'a']++;
        }
        for (char c : w2) {
            letter1[c - 'a']--;
        }
        return 1;
    }

    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 1; i <= len1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for(int j = 1;j <= len2; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }

        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                // 删除操作：dp[i - 1][j]
                // 增加操作：dp[i][j - 1]
                // 替换操作：dp[i - 1][j - 1]
                dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                // 如果当前位置字符相同,那么可以直接用dp[i-1][j-1],因为有没有当前字符不改变任何东西
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
            }
        }

        return dp[len1][len2];
    }
}
