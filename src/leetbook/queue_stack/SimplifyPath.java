package leetbook.queue_stack;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LC 71
 *
 * @author: Yihu4
 * @create: 2022-01-06 19:45
 */
public class SimplifyPath {
    @Test
    public void test() {
        System.out.println(simplifyPath("/a/.."));
    }

    public String simplifyPath(String path) {
        Deque<String> d = new ArrayDeque<>();
        int n = path.length();
        for (int i = 1; i < n; ) {
            if (path.charAt(i) == '/' && ++i >= 0) {
                continue;
            }
            int j = i + 1;
            while (j < n && path.charAt(j) != '/') {
                j++;
            }
            String item = path.substring(i, j);
            if (item.equals("..")) {
                if (!d.isEmpty()) {
                    d.pollLast();
                }
            } else if (!item.equals(".")) {
                d.addLast(item);
            }
            i = j;
        }
        StringBuilder sb = new StringBuilder();
        while (!d.isEmpty()) {
            sb.append("/" + d.pollFirst());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
