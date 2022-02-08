package leetbook.DynamicPrograming.linear;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * LC 368
 * 返回数组中最大的可以互相整除的集合
 *
 * @author: Yihu4
 * @create: 2021-12-06 16:15
 */
public class LargestDivisibleSubset {
    @Test
    public void test() {
        int[] ints = {3, 4, 16, 8};
        System.out.println(largestDivisibleSubsetSans(ints));
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, List<Integer>> dp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            dp.put(i, new ArrayList<>());
        }
        dp.get(0).add(nums[0]);
        List<Integer> res = new ArrayList<>();
        res.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp.get(i).size() == 0) {
                    dp.get(i).add(nums[i]);
                }
                if (nums[i] % nums[j] == 0) {
                    if (dp.get(j).size() >= dp.get(i).size() - 1) {
                        List<Integer> list = dp.get(j);
                        List<Integer> tmp = new ArrayList<>(list);
                        tmp.add(nums[i]);
                        dp.put(i, tmp);
                    }
                }
            }
            if (dp.get(i).size() > res.size()) {
                res = dp.get(i);
            }
        }
        return res;
    }

    public List<Integer> largestDivisibleSubsetSans(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] f = new int[n];
        int[] g = new int[n];
        for (int i = 0; i < n; i++) {
            // 至少包含自身一个数，因此起始长度为 1，由自身转移而来
            int len = 1, prev = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    // 如果能接在更长的序列后面，则更新「最大长度」&「从何转移而来」
                    if (f[j] + 1 > len) {
                        len = f[j] + 1;
                        prev = j;
                    }
                }
            }
            // 记录「最终长度」&「从何转移而来」
            f[i] = len;
            // 用于最后回溯
            g[i] = prev;
        }

        // 遍历所有的 f[i]，取得「最大长度」和「对应下标」
        int max = -1, idx = -1;
        for (int i = 0; i < n; i++) {
            if (f[i] > max) {
                idx = i;
                max = f[i];
            }
        }

        // 使用 g[] 数组回溯出具体方案
        List<Integer> ans = new ArrayList<>();
        while (ans.size() != max) {
            ans.add(nums[idx]);
            idx = g[idx];
        }
        return ans;
    }
}
