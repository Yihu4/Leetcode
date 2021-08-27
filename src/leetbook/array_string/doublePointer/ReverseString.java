package leetbook.array_string.doublePointer;

/**
 * LC 344
 * @author: mete0ra
 * @create: 2021-08-24 14:06
 */
public class ReverseString {
    public static void main(String[] args) {

    }

    // 双指针
    public static void reverseString(char[] s) {
        for (int l = 0, r = s.length -1; l < r; l++, r--) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
        }
    }
}
