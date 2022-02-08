package leetbook.heap;

import java.util.PriorityQueue;

/**
 * LC 1405
 * @author: Yihu4
 * @create: 2022-02-08 22:56
 */
public class LongestHappyString {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        // 二元数组第二个元素排序(大根堆)
        PriorityQueue<int[]> q = new PriorityQueue<>((x,y)->y[1]-x[1]);
        // 添加a/b/c元素进入优先队列
        if (a > 0) {
            q.add(new int[]{0, a});
        }
        if (b > 0) {
            q.add(new int[]{1, b});
        }
        if (c > 0) {
            q.add(new int[]{2, c});
        }
        // 消费队列元素
        while (!q.isEmpty()) {
            // 取出当前最大堆
            int[] cur = q.poll();
            // 判断当前结果串长度
            int n = sb.length();
            // 判断当前结果串最后一个字符是否与当前最大堆中的相等
            if (n >= 2 && sb.charAt(n - 1) - 'a' == cur[0] && sb.charAt(n - 2) - 'a' == cur[0]) {
                if (q.isEmpty()) {
                    break;
                }
                // 取出第二大的
                int[] next = q.poll();
                // 强转char字符
                sb.append((char)(next[0] + 'a'));
                // 消费当前最大堆
                next[1]--;
                // 重新入堆第二大的
                if (next[1] != 0) {
                    q.add(next);
                }
                // 重新入堆
                q.add(cur);
            } else {
                sb.append((char)(cur[0] + 'a'));
                cur[1]--;
                if (cur[1] != 0) q.add(cur);
            }
        }
        return sb.toString();
    }
}
