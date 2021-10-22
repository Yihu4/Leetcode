package leetbook.HashTable.summary;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 454
 * 给四个int 数组,返回从每个数组中取一个数相加得0 的个数
 *
 * @author: Yihu4
 * @create: 2021-10-13 17:57
 */
public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> countAB = new HashMap<Integer, Integer>();
        for (int u : nums1) {
            for (int v : nums2) {
                // 如果组合结果重复,Integer 就+1
                // getOrDefault,没有就 1,有就获取再+1
                countAB.put(u + v, countAB.getOrDefault(u + v, 0) + 1);
            }
        }
        int ans = 0;
        for (int u : nums3) {
            for (int v : nums4) {
                if (countAB.containsKey(-u - v)) {
                    // 如果匹配到就加
                    ans += countAB.get(-u - v);
                }
            }
        }
        return ans;
    }
}
