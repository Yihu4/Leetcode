package leetbook.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC 539
 *
 * @author: Yihu4
 * @create: 2022-01-18 16:03
 */
public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        int size = timePoints.size();
        int[] ints = new int[size];
        for (int i = 0;i<size;i++) {
            String[] split = timePoints.get(i).split(":");
            int t = Integer.parseInt(split[0]) * 60;
            // 时间戳
            t+=Integer.parseInt(split[1]);
            ints[i]=t;
        }
        Arrays.sort(ints);
        int min = Integer.MAX_VALUE;
        int last = ints[ints.length - 1];
        min = 24*60-last+ints[0];
        for (int i = 1; i < ints.length; i++) {
            min = Math.min(min,ints[i]-ints[i-1]);
        }
        return min;
    }
}
