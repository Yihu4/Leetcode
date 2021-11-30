package leetbook.DynamicPrograming.unclassified;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC 120
 * 三角形从上到下最短线路
 *
 * @author: Yihu4
 * @create: 2021-11-29 19:41
 */
public class Triangle {
    @Test
    public void test(){
        List<List<Integer>> lists = new ArrayList<>();

        List<Integer> integers = new ArrayList<>();
        integers.add(2);
        lists.add(integers);
        integers.remove(0);
        integers.add(3);
        integers.add(4);
        lists.add(integers);
        System.out.println(minimumTotalBottomToTop(lists));
    }

    // 自上向下需要考虑左边界
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int[] dp = new int[triangle.size() + 1];
        for (int i = 0; i < triangle.size(); i++) {
            int last = Integer.MAX_VALUE;
            int tmp = 0;
            List<Integer> list = triangle.get(i);
            for (int j = 1; j <= list.size(); j++) {
                tmp = dp[j];
                // 比上一个和这一个
                dp[j]=Math.min(last,dp[j]);
                dp[j]+=list.get(j-1);
                last=tmp;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < dp.length; i++) {
            res = Math.min(res,dp[i]);
        }
        return res;
    }

    // 从底向上也一样,好处是不用考虑边界
    public int minimumTotalBottomToTop(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for (int i = 0; i < triangle.size(); i++) {
            dp[i]=triangle.get(triangle.size()-1).get(i);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
