package leetbook.heap;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * LC 506
 * @author: Yihu4
 * @create: 2021-12-02 09:51
 */
public class RelativeRanks {
    @Test
    public void test(){
        int[] ints = {10, 3, 8, 9, 4};
        System.out.println(Arrays.toString(findRelativeRanks(ints)));
    }
    // "Gold Medal","Silver Medal","Bronze Medal"
    public String[] findRelativeRanks(int[] score) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            map.put(score[i],i);
        }
        // 最大堆
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i : score) {
            pq.offer(i);
        }
        String[] res = new String[score.length];
        String[] ss = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};
        int len = Math.min(score.length,3);
        for (int i = 0; i < len; i++) {
            Integer poll = pq.poll();
            Integer integer = map.get(poll);
            res[integer]=ss[i];
        }
        int count = 4;
        while (!pq.isEmpty()){
            Integer poll = pq.poll();
            Integer integer = map.get(poll);
            res[integer]=count+"";
            count++;
        }
        return res;
    }
}
