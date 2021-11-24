package leetbook.SlidingWindow.window2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * LC 438
 *
 * @author: Yihu4
 * @create: 2021-11-11 21:32
 */
public class FindAllAnagramsinaString {
    @Test
    public void test(){
        String s= "cbaebabacd";
        System.out.println(findAnagrams(s, "abc"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length(), m = p.length();
        List<Integer> res = new ArrayList<>();
        if(n < m) return res;

        int[] pCnt = new int[26];
        int[] sCnt = new int[26];

        for(int i = 0; i < m; i++){
            pCnt[p.charAt(i) - 'a'] ++;
        }

        int left = 0;
        for(int right = 0; right < n; right++){
            int curRight = s.charAt(right) - 'a';
            // 在s数组中记录当前s字符
            sCnt[curRight]++;
            while(sCnt[curRight] > pCnt[curRight]){
                // 若出现 重复/多余 字符，则窗口左边界一直向右移动，直至移动到正确位置。正确位置就是窗口内没有 重复/多余 的字符。
                // 当有任意当前大于p时,缩小左边界,直到当前对应的字符满足p的条件
                int curLeft = s.charAt(left) - 'a';
                sCnt[curLeft]--;
                left++;////////
            }
            if(right - left + 1 == m){
                res.add(left);
            }
        }
        return res;
    }

}
