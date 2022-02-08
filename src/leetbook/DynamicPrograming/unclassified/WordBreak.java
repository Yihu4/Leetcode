package leetbook.DynamicPrograming.unclassified;

import org.junit.Test;

import java.util.*;

/**
 * LC 139
 *
 * @author: Yihu4
 * @create: 2021-11-23 10:32
 */
public class WordBreak {
    @Test
    public void test() {
        List<String> strings = new ArrayList<>();
        strings.add("apple");
        strings.add("pen");
        wordBreak("applepenapple", strings);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int maxWordLength = 0;
        Set<String> wordSet = new HashSet<>(wordDict.size());
        // 选出列表里最长的
        for (String word : wordDict) {
            wordSet.add(word);
            if (word.length() > maxWordLength) {
                maxWordLength = word.length();
            }
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = (Math.max(i - maxWordLength, 0)); j < i; j++) {
                // 如果j之前包含, 并且j到i中的单词在set之中
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    // 剪枝记忆化
    public boolean wordBreakDFS(String s, List<String> wordDict) {
        boolean[] visited = new boolean[s.length() + 1];
        return dfs(s, 0, wordDict, visited);
    }

    private boolean dfs(String s, int start, List<String> wordDict, boolean[] visited) {
        for (String word : wordDict) {
            // 下一个单词的长度
            int nextStart = start + word.length();
            // 如果超过了s长度或者访问过了
            if (nextStart > s.length() || visited[nextStart]) {
                continue;
            }
            // 如果这个单词在string中紧邻现在的范围
            if (s.indexOf(word, start) == start) {
                // 如果到底了或者重复这种过程到底了,返回true
                if (nextStart == s.length() || dfs(s, nextStart, wordDict, visited)) {
                    return true;
                }
                // 将访问过的下标放入visited数组, 避免重复计算
                visited[nextStart] = true;
            }
        }
        return false;
    }

    public boolean wordBreakBFS(String s, List<String> wordDict) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        boolean[] visited = new boolean[s.length() + 1];

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int start = queue.poll().intValue();
                for (String word : wordDict) {
                    int nextStart = start + word.length();
                    if (nextStart > s.length() || visited[nextStart]) {
                        continue;
                    }

                    if (s.indexOf(word, start) == start) {
                        if (nextStart == s.length()) {
                            return true;
                        }
                        // 每一层
                        queue.add(nextStart);
                        // 将访问过的下标放入visited数组, 避免重复计算
                        visited[nextStart] = true;
                    }
                }
            }
        }
        return false;
    }
}