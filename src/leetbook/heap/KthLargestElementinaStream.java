package leetbook.heap;

/**
 * LC 703
 * @author: Yihu4
 * @create: 2021-11-22 14:00
 */
public class KthLargestElementinaStream {

    int[] heap;
    int size = 0;
    int count = 0;
    public KthLargestElementinaStream(int k, int[] nums) {
        heap = new int[k];
        count = k;

        // 初始化一个大小为k的小根堆
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }

    }

    public int add(int val) {

        if (size < count) {
            heap[size] = val;
            up(size);
            size++;
        } else if (heap[0] < val) {
            heap[0] = val;
            down(0);
        }

        return heap[0];
    }

    // 自上向下调整堆
    public void down (int u) {
        int t = u;
        if (2 * u + 1 < size && heap[2 * u + 1] < heap[t])
            t = 2 * u + 1;
        if (2 * u + 2 < size && heap[2 * u + 2] < heap[t])
            t = 2 * u + 2;
        if (t != u) {
            int temp = heap[u];
            heap[u] = heap[t];
            heap[t] = temp;
            down (t);
        }
    }

    // 自下向上调整堆
    public void up (int u) {
        // 存在父亲节点, 并且父亲节点的值大于当前值, 则进行交换
        while ((int)(Math.ceil(u / 2.0) - 1) >= 0 && heap[(int)Math.ceil(u / 2.0) - 1] > heap[u]) {
            int p = (int)(Math.ceil(u / 2.0) - 1);
            int temp = heap[u];
            heap[u] = heap[p];
            heap[p] = temp;
            u = p;
        }
    }

}
