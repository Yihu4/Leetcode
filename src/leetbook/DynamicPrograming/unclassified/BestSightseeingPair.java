package leetbook.DynamicPrograming.unclassified;

import org.junit.Test;

import java.security.PublicKey;

/**
 * LC 1014
 *
 * @author: Yihu4
 * @create: 2021-11-22 17:38
 */
public class BestSightseeingPair {
    @Test
    public void test() {
        int[] ints = {8, 1, 5, 2, 6};
        System.out.println(maxScoreSightseeingPair(ints));
    }


    public int maxScoreSightseeingPair(int[] values) {
        // 因为values[i]+values[j]+i-j中          values[j]-j 是固定的
        // 所以要求最大值需要找到j之前    values[i]+i的最大值->维护preMax
        int res = 0;
        int preMax = values[0];
        for (int i = 1; i < values.length; i++) {
            res = Math.max(res, preMax + values[i] - i);
            preMax = Math.max(preMax, values[i] + i);
        }
        return res;
    }
}
