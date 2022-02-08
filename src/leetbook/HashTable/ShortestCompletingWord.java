package leetbook.HashTable;

import org.junit.Test;

/**
 * LC 748
 *
 * @author: Yihu4
 * @create: 2021-12-10 10:39
 */
public class ShortestCompletingWord {
    @Test
    public void test(){
        String[] strings = {"step", "steps", "stripe", "stepple"};
        shortestCompletingWord("1s3 PSt",strings);
    }
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] cnts = counter(licensePlate);
        int len = 1001;
        String ans = null;
        for (String word : words) {
            if (word.length() < len) {
                int[] ws = counter(word);
                boolean ok = true;
                // 一旦发现有字母不符合,则置false
                for (int i = 0; i < 26; i++) {
                    if (cnts[i]>ws[i]){
                        ok=false;
                    }
                }
                // 如果所有字母都符合
                if (ok) {
                    // 更新长度
                    len = word.length();
                    ans = word;
                }
            }
        }
        return ans;
    }

    private int[] counter(String word) {
        int[] cnts = new int[26];
        for (int i = 0; i < word.length(); i++) {
            // 只统计大小写字符
            char c = word.charAt(i);
            if (c <= 'z' && c >= 'a')
                cnts[c - 'a']++;
            else if (c <= 'Z' && c >= 'A')
                cnts[c - 'A']++;
        }
        return cnts;
    }
}
