package leetbook.HashTable.HashMap;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * LC 350
 * 查交集
 *
 * @author: Yihu4
 * @create: 2021-09-24 15:13
 */
public class IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        // 记录第一个集
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            // 有重合
            if (map.containsKey(nums2[i])) {
                if (map.get(nums2[i]) > 0) {
                    res.add(nums2[i]);
                    map.put(nums2[i], map.get(nums2[i]) - 1);
                }
            }
        }
        int[] d = new int[res.size()];
        for (int i = 0; i < d.length; i++) {
            d[i] = res.get(i);
        }
        // int[] intArr = list.stream().mapToInt(Integer::intValue).toArray();
        return d;
    }

    public int[] intersectAg(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (Integer i : nums2) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) - 1);
                res.add(i);
                if (map.get(i) == 0) {
                    map.remove(i);
                }
            }
        }
        int[] ints = res.stream().mapToInt(p -> p).toArray();
        return ints;
    }
}
