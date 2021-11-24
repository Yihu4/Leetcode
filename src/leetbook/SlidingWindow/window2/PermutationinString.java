package leetbook.SlidingWindow.window2;

/**
 * LC 567
 * @author: Yihu4
 * @create: 2021-11-12 20:11
 */
public class PermutationinString {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1char = new int[26];
        // 记录s1的字母
        for (int i = 0; i < s1.length(); i++) {
            s1char[s1.charAt(i)-'a']++;
        }
        int[] s2char = new int[26];
        int size = s1.length();
        int left = 0;
        for (int right = 0; right < s2.length(); right++) {
            int curRight = s2.charAt(right)-'a';
            s2char[curRight]++;
            while (s2char[curRight]>s1char[curRight]){
                // 缩小左窗口
                s2char[s2.charAt(left)-'a']--;
                left++;
            }
            if (right-left +1 ==size){
                return true;
            }
        }
        return false;
    }
}
