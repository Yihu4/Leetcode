package leetbook.array;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * LC 1705
 *
 * @author: Yihu4
 * @create: 2021-12-24 09:43
 */
public class MaximumNumberofEatenApples {
    @Test
    public void test() {
        int[] ints = {0};
        int[] int1s = {1};
        System.out.println(eatenApples(ints, int1s));
    }

    public int eatenApples(int[] apples, int[] days) {
        // 先吃容易腐烂的
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int day = 0;
        int res = 0;
        while (day < apples.length || !pq.isEmpty()) {
            // 如果天数在apples列表之内,并且那一天的苹果数量不为0
            if (day < apples.length && apples[day] != 0) {
                pq.offer(new int[]{day + days[day] - 1, apples[day]});
            }
            // 如果队列不为空并且过期,则推出过期苹果
            while (!pq.isEmpty() && pq.peek()[0] < day) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                // 今天要吃的苹果
                int[] cur = pq.poll();
                // 如果苹果还有剩余,并且明天还能吃,就放回
                if (--cur[1] != 0 && cur[0] >= day + 1) {
                    pq.add(cur);
                }
                res++;
            }
            day++;
        }
        return res;
    }

    public int eatenApplesAlter(int[] apples, int[] days) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int i = 0, ans = 0, n = apples.length;
        for (; i < n; i++) {
            while (!pq.isEmpty() && pq.peek()[0] <= i)
                pq.poll();
            if (apples[i] > 0)
                pq.add(new int[]{i + days[i], apples[i]});
            if (!pq.isEmpty()) {
                ans++;
                if (--pq.peek()[1] == 0)
                    pq.poll();
            }
        }
        // 剩下的天
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int diff = Math.min(cur[0] - i, cur[1]);
            i += diff;
            ans += diff;
            while (!pq.isEmpty() && pq.peek()[0] <= i)
                pq.poll();
        }
        return ans;
    }
}