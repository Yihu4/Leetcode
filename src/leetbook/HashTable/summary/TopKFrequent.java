package leetbook.HashTable.summary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * LC 347
 * @author: Yihu4
 * @create: 2021-10-13 19:49
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer i :
                nums) {
            map.put(i, map.getOrDefault(i,0)+1);
        }
        // 数组列表
        List<int[]> list = new ArrayList<>();
        // map 遍历数组列表
        map.forEach((key, value) -> { list.add(new int[]{key, value}); });
        // 排序,升序
        list.sort(Comparator.comparingInt(a -> a[1]));
        int[] res = new int[k];

        for (int i = 0, j = list.size() - 1; i < k; i++, j--) {
            res[i] = list.get(j)[0];
        }
        return res;

    }
}
