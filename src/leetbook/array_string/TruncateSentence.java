package leetbook.array_string;

/**
 * LC 1816
 * @author: Yihu4
 * @create: 2021-12-06 10:02
 */
public class TruncateSentence {

    public String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0, cnt = 0; i < n && cnt < k; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                cnt++;
            }
            if (cnt < k) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String truncateSentenceSplit(String s, int k) {
        String[] s1 = s.split(" ");
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < k; i++) {
            stringBuffer.append(s1[i]);
            stringBuffer.append(" ");
        }
        stringBuffer.deleteCharAt(stringBuffer.length()-1);
        return stringBuffer.toString();
    }
}
