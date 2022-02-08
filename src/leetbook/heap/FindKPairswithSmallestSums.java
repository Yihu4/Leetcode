package leetbook.heap;

import org.junit.Test;

import java.util.*;

/**
 * LC 373
 * 从两格数组中各选出一个组成最小,kv不能重复
 *
 * @author: Yihu4
 * @create: 2022-01-14 11:57
 */
public class FindKPairswithSmallestSums {
    @Test
    public void test() {
        int[] ints = {1,7,11};
        int[] ints1 = {2,4,88};
        kSmallestPairsAlter(ints, ints1, 3);
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        TreeMap<Integer, List<List<Integer>>> treeMap = new TreeMap<>();
        int cur = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                cur = nums1[i] + nums2[j];
                ArrayList<Integer> list = new ArrayList<>();
                list.add(nums1[i]);
                list.add(nums2[j]);
                List<List<Integer>> tmp = new ArrayList<>();
                List<List<Integer>> lists = treeMap.getOrDefault(cur, tmp);
                lists.add(list);
                treeMap.put(cur, lists);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!treeMap.isEmpty() && k > 0) {
            Integer i = treeMap.firstKey();
            List<List<Integer>> lists = treeMap.get(i);
            if (lists.size() == 0) {
                treeMap.remove(i);
            } else {
                List<Integer> list = lists.get(lists.size() - 1);
                res.add(list);
                lists.remove(lists.size() - 1);
                k--;
            }
        }
        return res;
    }
    public List<List<Integer>> kSmallestPairsAlter(int[] nums1, int[] nums2, int k) {
        // 优先级队列，保存 [index1, index2]
        // 按照下标对应的和,升序排列
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> nums1[a[0]] + nums2[a[1]] - (nums1[b[0]] + nums2[b[1]]));
        // 把 nums1 的所有索引入队，nums2 的索引初始时都是 0
        // 优化：最多入队 k 个就可以了，因为提示中 k 的范围较小，这样可以提高效率
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            heap.offer(new int[] {i, 0});
        }
        List<List<Integer>> ans = new ArrayList<>();
        // 最多弹出 k 次
        while (k-- > 0 && !heap.isEmpty()) {
            int[] pos = heap.poll();
            ans.add(Arrays.asList(nums1[pos[0]], nums2[pos[1]]));
            // 将 index2 加 1 之后继续入队
            if (++pos[1] < nums2.length) {
                heap.offer(pos);
            }
        }
        return ans;
    }
}
