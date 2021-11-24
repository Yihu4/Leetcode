package leetbook.SlidingWindow.window2;

import org.junit.Test;

/**
 * LC 424
 *
 * @author: Yihu4
 * @create: 2021-11-10 11:18
 */
public class LongestRepeatingCharacterReplacement {
    @Test
    public void test(){
        String s = "AABABBA";
        System.out.println(characterReplacement(s, 1));
    }
    public int characterReplacement(String s, int k) {
        if (s.length()<2){
            return s.length();
        }
        int[] freq = new int[26];
        int left = 0;
        int maxCount = 0;
        int res = 0;
        for (int right = 0; right < s.length(); right++) {
            // 记录该下标上的字母
            freq[s.charAt(right) - 'A']++;
            // 更新当前窗口内的字母(或者说主字母)的最大值
            maxCount = Math.max(maxCount, freq[s.charAt(right) - 'A']);
            // 如果窗口长度大于了   目前窗口内的单个最大字母数量加可替换字母次数k, 去缩小窗口的左边界
            // while 和 if没有区别, 因为至多执行一次
            if (right +1 - left > maxCount + k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            // 记录满足条件下的最大长度
            res = Math.max(res, right +1 - left);
        }
        return res;
    }
}
