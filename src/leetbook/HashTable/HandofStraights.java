package leetbook.HashTable;

import org.junit.Test;

import java.util.*;

/**
 * LC 846
 *
 * @author: Yihu4
 * @create: 2021-12-30 11:55
 */
public class HandofStraights {
    @Test
    public void test() {
        int[] ints = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        System.out.println(isNStraightHandLC(ints, 3));
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(hand);
        for (Integer i : hand) {
            pq.add(i);
        }
        int count = 0;
        int pre = -1;
        while (!pq.isEmpty()){
            // 如果是第一个
            if (pre == -1) {
                pre = pq.poll();
                count++;
            } else {
                if (pq.contains(pre + 1)) {
                    pq.remove(pre + 1);
                    pre = pre +1;
                    count++;
                } else {
                    return false;
                }
            }
            if (count == groupSize) {
                count = 0;
                pre = -1;
            }
        }
        if (count != 0) {
            return false;
        }
        return true;
    }

    public boolean isNStraightHandLC(int[] hand, int m) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->a-b);
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            q.add(i);
        }
        while (!q.isEmpty()) {
            // 每个顺子的起始
            int t = q.poll();
            if (map.get(t) == 0) {
                continue;
            }
            for (int i = 0; i < m; i++) {
                // 沿着起始数+1 get map中的
                int cnt = map.getOrDefault(t + i, 0);
                if (cnt == 0) {
                    return false;
                }
                map.put(t + i, cnt - 1);
            }
        }
        return true;
    }
}
