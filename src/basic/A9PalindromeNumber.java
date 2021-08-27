package basic;

/**
 * LC 9
 *
 * @author: mete0ra
 * @create: 2021-08-26 09:41
 */
public class A9PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = String.valueOf(x);

        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {

            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
