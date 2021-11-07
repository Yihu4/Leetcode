package leetbook.array.CollisionPointer;

/**
 * LC 125
 * 验证回文
 * @author: Yihu4
 * @create: 2021-11-06 10:05
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int l = 0;
        int r = n - 1;
        while (l < r){
            while (l<r && !Character.isLetterOrDigit(s.charAt(l))){
                // 过滤非字母或者数字的字符
                l++;
            }
            while (l<r && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }
            if (l<r){
                if (Character.toLowerCase(s.charAt(l))!=Character.toLowerCase(s.charAt(r))){
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }
}
