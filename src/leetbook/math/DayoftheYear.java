package leetbook.math;

/**
 * LC 1154
 *
 * @author: Yihu4
 * @create: 2021-12-22 09:54
 */
public class DayoftheYear {
    static int[] nums = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int[] f = new int[13];

    static {
        // 前缀和
        for (int i = 1; i <= 12; i++) {
            f[i] = f[i - 1] + nums[i - 1];
        }
    }

    public int dayOfYear(String date) {
        String[] ss = date.split("-");
        int y = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);
        int d = Integer.parseInt(ss[2]);
        // 判断是否是闰年
        boolean isLeap = (y % 4 == 0 && y % 100 != 0) || y % 400 == 0;
        int ans = m > 2 && isLeap ? f[m - 1] + 1 : f[m - 1];
        return ans + d;
    }
}
