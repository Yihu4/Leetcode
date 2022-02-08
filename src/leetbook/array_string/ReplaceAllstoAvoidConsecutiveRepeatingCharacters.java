package leetbook.array_string;

import org.junit.Test;

/**
 * LC 1576
 * @author: Yihu4
 * @create: 2022-01-05 19:44
 */
public class ReplaceAllstoAvoidConsecutiveRepeatingCharacters {
    @Test
    public void test(){
        System.out.println(modifyString("a??????"));
    }
    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int c = 0; c < 3 && chars[i] == '?'; c++) {
                boolean ok = true;
                if (i - 1 >= 0 && chars[i - 1] == c + 'a') {
                    ok = false;
                }
                if (i + 1 < chars.length && chars[i + 1] == c + 'a') {
                    ok = false;
                }
                if (ok) {
                    chars[i] = (char) (c + 'a');
                }
            }
        }
        return String.valueOf(chars);
    }
}
