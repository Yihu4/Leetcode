package leetbook.BinarySearch.LC;

import java.util.Arrays;

/**
 * LC 1482
 * @author: Yihu4
 * @create: 2021-11-02 21:12
 */
public class MakemBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay == null || bloomDay.length < m * k) {
            return -1;
        }
        int l = 1, r = Arrays.stream(bloomDay).max().getAsInt();
        while (l < r) {
            int mid = l + (r - l) / 2;
            int numMake = 0, numBloom = 0;
            // 获取该天数下能做成几束花
            for (int i : bloomDay) {
                numBloom = i <= mid ? numBloom + 1 : 0;
                if (numBloom == k) {
                    numMake++;
                    numBloom = 0;
                }
            }
            if (numMake >= m) {
                // 如果做的花大于需求的,缩短天数
                r = mid;
            } else {
                // 小于需求,增大天数
                l = mid + 1;
            }
        }
        return l;
    }
}
