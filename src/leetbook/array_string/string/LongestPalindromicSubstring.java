package leetbook.array_string.string;

/**
 * @author: mete0ra
 * @create: 2021-08-05 18:08
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindromeBl(s));
    }

    /**
     * 暴力
     */
    public static String longestPalindromeBl(String s) {
        String res = "";
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            // <= 因为要考虑s只有一个字符的情况
            for (int j = i + 1; j <= s.length(); j++) {
                // 临时字符串,判断是不是回文
                String temp = s.substring(i, j);
                if (isPalindrome(temp) && temp.length() > max) {
                    res = temp;
                    max = temp.length();

                }
            }
        }
        return res;
    }

    public static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
