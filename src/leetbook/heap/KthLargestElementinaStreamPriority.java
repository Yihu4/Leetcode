package leetbook.heap;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * LC 703
 *
 * @author: Yihu4
 * @create: 2021-11-22 14:00
 */
public class KthLargestElementinaStreamPriority {

    PriorityQueue<Integer> heap;
    int k = 0;

    public KthLargestElementinaStreamPriority(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<Integer>(k);

        for (int i : nums)
            add(i);

    }

    public int add(int val) {

        if (heap.size() < k) {
            heap.offer(val);
        } else if (heap.peek() < val) {
            // 只会poll当前最小
            heap.poll();
            heap.offer(val);
        }

        return heap.peek();
    }
}

