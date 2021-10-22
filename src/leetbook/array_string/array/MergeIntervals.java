package leetbook.array_string.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * LC 56
 * @author meteora
 */
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 3}, {1, 2}, {4, 5}, {3, 7}};
        test(nums);


        // 打印二维数组
        //System.out.println((Arrays.deepToString(merge1(nums))));

    }

    public static int[][] merge(int[][] intervals) {
        // 按照第二维的第一个元素升序排列, lambda
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int count = -1;
        int[][] res = new int[intervals.length][2];
        for (int i = 0; i < intervals.length; i++) {
            // 如果新数组的左大于旧数组的右,则新建数组
            if (count == -1 || intervals[i][0] > res[count][1]) {
                res[++count] = intervals[i];
                // 否则,合并
            } else {
                res[count][1] = Math.max(res[count][1], intervals[i][1]);
            }
        }
        return Arrays.copyOf(res,count + 1);
    }

    public static void test(int[][] nums) {
        // v1, v2是第二维?
        Arrays.sort(nums, (v1, v2) -> v1[1] - v2[1]);
        // 打印二维数组
        for (int[] num : nums) {
            System.out.println(Arrays.toString(num));
        }
        System.out.println(Arrays.toString(nums[0]));
    }

    public static int[][] merge1(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        /**
         *
         * Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]); 假设传来两个值，v1 与 v2，
         * 那么他们的先后顺序以 v1[0] 比 v2[0] 的结果为准，即：若 v1[0] < v2[0] 则 v1 < v2，若 = 则 =，若 > 则 >
         *
         * 举一反三：Arrays.sort(intervals, (v1, v2) -> v1[0] == v2[0] ? v2[1] - v1[1] : v1[0] - v2[0]);
         * 表示：传来两个值 v1 与 v2，若 [0] 相同，则按 [1] 降序；若不同则按 [0] 升序。为什么升序
         */

        // 按照第二维的第一个数字排序数组, 以下三个代码作用一样
        //对于它，则是针对一些本身没有比较能力的对象（数组）为它们实现比较的功能，
        // 所以它叫做比较器，是一个外部的东西，通过它定义比较的方式，
        // 再传到Collection.sort()和Arrays.sort()中对目标排序，而且通过自身的方法compare()定义比较的内容和结果的升降序；
        //Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);
        //Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        // 输出二维数组
        /*for (int[] num : nums) {
            System.out.println(Arrays.toString(num));
        }*/
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            // 将第一个区间加入 merged 数组中
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < left) {
                merged.add(new int[]{left, right});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], right);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }


    /**
     * 两两合并
     */
    public int[][] merge2(int[][] intervals) {
        // 先按照第二维的第一个数字排序数组
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        // 遍历区间
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
            // 则不合并，直接将当前区间加入结果数组。
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                // 反之将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }
}

