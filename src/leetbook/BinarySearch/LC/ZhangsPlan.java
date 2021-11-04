package leetbook.BinarySearch.LC;

/**
 * LCP 12
 *
 * @author: Yihu4
 * @create: 2021-11-03 21:31
 */
public class ZhangsPlan {
    public int minTime(int[] time, int m) {
        int n = time.length;
        if (m >= n) { // 如果天数大于等于题目数，每题都可以分配在不同天，并由求助完成
            return 0;
        }
        int l = 0;
        int r = 0;
        // 最大耗时为所有题目相加
        for (int i : time) {
            r += i;
        }
        while (l < r) { //二分查找
            int mid = (l + r) >> 1;
            if (check(time, m, mid) > m) {
                // 如果天数超过了m, 表示耗时太小,需要增大耗时
                l = mid + 1;
            } else { //否则左边界加一
                r = mid;
            }
        }
        return l;
    }

    // limit 最大耗时
    public int check(int[] time, int m, int limit) {
        // 当前遍历到的题目，当前组的总耗时，当前组的最大耗时，需要的天数
        int cur = 0, sum = 0, max = 0, day = 1;
        while (cur < time.length) {
            sum += time[cur];
            max = Math.max(max, time[cur]);
            if (sum - max > limit) { //当前组总耗时减去组内最大耗时仍超出限制，则需要开启额外一天
                day++;
                /*if (day > m) { //超出总天数m，无法完成分配
                    return false;
                }*/
                //sum和max更新为新组的值
                sum = time[cur];
                max = time[cur];
            }
            cur++;
        }
        return day; //能遍历完所有题目即完成了分配
    }

}
