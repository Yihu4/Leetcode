package leetbook.SlidingWindow.window1;

/**
 * LC 1456
 * @author: Yihu4
 * @create: 2021-11-06 18:22
 */
public class MaximumNumberofVowelsinaSubstringofGivenLength {
    public int maxVowels(String s, int k) {
        int cur = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))==1){
                cur+=1;
            }
        }
        int res = cur;
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i-k))==1){
                cur-=1;
            }
            if (isVowel(s.charAt(i))==1){
                cur+=1;
            }
            res = Math.max(res,cur);
        }
        return res;
    }
    public int isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ? 1 : 0;
    }
}
